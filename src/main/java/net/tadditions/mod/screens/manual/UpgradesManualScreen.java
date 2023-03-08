package net.tadditions.mod.screens.manual;

import com.google.common.collect.Lists;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.ChangePageButton;
import net.minecraft.item.ItemStack;
import net.minecraft.resources.IResource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.tadditions.mod.QolMod;
import net.tardis.mod.Tardis;
import net.tadditions.mod.screens.manual.pages.Page;
import net.tadditions.mod.screens.manual.pages.TOCPage;
import net.tardis.mod.client.guis.widgets.ChangeChapterButton;
import net.tardis.mod.client.guis.widgets.ReturnToIndexButton;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.contexts.gui.GuiItemContext;
import net.tardis.mod.misc.GuiContext;
import net.tardis.mod.network.Network;
import net.tardis.mod.network.packets.UpdateManualPageMessage;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class UpgradesManualScreen extends Screen {

    public static final ResourceLocation TEXTURE = new ResourceLocation(QolMod.MOD_ID, "textures/gui/upgrades_manual.png");
    private List<Chapter> chapters = Lists.newArrayList();

    private int pageIndex = 0;
    private int chapterIndex = 0;
    private String modid;

    private static final TranslationTextComponent NEXT_PAGE = new TranslationTextComponent("tooltip.tardis.manual.next_page");
    private static final TranslationTextComponent PREV_PAGE = new TranslationTextComponent("tooltip.tardis.manual.previous_page");
    private static final TranslationTextComponent NEXT_CHAPTER = new TranslationTextComponent("tooltip.tardis.manual.next_chapter");
    private static final TranslationTextComponent PREV_CHAPTER = new TranslationTextComponent("tooltip.tardis.manual.previous_chapter");
    private static final TranslationTextComponent LAST_PAGE = new TranslationTextComponent("tooltip.tardis.manual.last_page");
    private static final TranslationTextComponent FIRST_PAGE = new TranslationTextComponent("tooltip.tardis.manual.first_page");

    private ChangePageButton pageForward;
    private ChangePageButton pageBack;
    private ChangeChapterButton chapterForward;
    private ChangeChapterButton chapterBack;
    private ReturnToIndexButton endOfManual;
    private ReturnToIndexButton startOfManual;

    public int pageX = width / 2 - 110;
    public int pageY = height / 2 - 70;
    public int page2X = pageX + 120;

    protected UpgradesManualScreen(ITextComponent titleIn, String modid) {
        super(titleIn);
        this.modid = modid;
        this.read();
        this.insertTOC();
    }

    public UpgradesManualScreen(GuiContext context){
        this(new StringTextComponent("Manual Vol.2"), QolMod.MOD_ID);
        if (context instanceof GuiItemContext) {
            ItemStack stack = ((GuiItemContext) context).getItemStack();
            if (stack.hasTag()) {
                if(stack.getTag().contains("page"))
                    pageIndex = stack.getTag().getInt("page");
                if (stack.getTag().contains("chapter"))
                    chapterIndex = stack.getTag().getInt("chapter");
            }
        }
    }
    
    @Override
    public void closeScreen() {
        Network.sendToServer(new UpdateManualPageMessage(this.pageIndex, this.chapterIndex));
        super.closeScreen();
    }

    @Override
    protected void init() {
        super.init();

        this.read();
        this.buttons.clear();

        this.addButton(pageForward = new ChangePageButton(width / 2 + 95, height / 2 + 70, true, button -> {
            this.turnPage(true);
        }, true));

        this.addButton(pageBack = new ChangePageButton(width / 2 - 120, height / 2 + 70, false, button -> {
            this.turnPage(false);
        }, true));
        
        this.addButton(chapterForward = new ChangeChapterButton(width / 2 + 25, height / 2 + 70, true, button -> {
            this.turnChapter(true);
        }, true));

        this.addButton(chapterBack = new ChangeChapterButton(width / 2 - 45, height / 2 + 70, false, button -> {
            this.turnChapter(false);
        }, true));

        this.updatePageWidths();
        this.insertTOC();
        
        this.addButton(endOfManual = new ReturnToIndexButton(width / 2 + 125, height / 2 - 85, true, button -> {
            this.turnToTableOfContents(true);
        }, true));
        
        this.addButton(startOfManual = new ReturnToIndexButton(width / 2 - 140, height / 2 - 85, false, button -> {
            this.turnToTableOfContents(false);
        }, true));

    }

    public void openPage(int chapterIndex, int pageIndex){
        this.chapterIndex = chapterIndex;
        this.pageIndex = pageIndex;
    }

    public void updatePageWidths(){
        pageX = width / 2 - 110;
        pageY = height / 2 - 70;
        page2X = pageX + 120;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        Minecraft.getInstance().getTextureManager().bindTexture(this.getTexture());
        this.blit(matrixStack, (width - 256) / 2, (height - 187) / 2, 0, 0, 256, 187);

        super.render(matrixStack, mouseX, mouseY, partialTicks);



        //Render Pages
        Pair<Page, Page> pages = this.getPages();
        if(pages.getFirst() != null) {
            pages.getFirst().render(matrixStack, this.font, this.getGlobalPageNumber(), this.pageX, this.pageY, this.width, this.height);
        }
        if(pages.getSecond() != null){
            pages.getSecond().render(matrixStack, this.font, this.getGlobalPageNumber() + 1, this.page2X, this.pageY, this.width, this.height);
        }
        
        this.renderTooltips(matrixStack, mouseX, mouseY, partialTicks);
    }
    
    private void renderTooltips(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        if (this.pageForward.isHovered())
            this.renderTooltip(matrixStack, NEXT_PAGE, mouseX, mouseY);
        if (this.pageBack.isHovered())
            this.renderTooltip(matrixStack, PREV_PAGE, mouseX, mouseY);
        if (this.chapterForward.isHovered())
            this.renderTooltip(matrixStack, NEXT_CHAPTER, mouseX, mouseY);
        if (this.chapterBack.isHovered())
            this.renderTooltip(matrixStack, PREV_CHAPTER, mouseX, mouseY);
        if (this.endOfManual.isHovered())
            this.renderTooltip(matrixStack, LAST_PAGE, mouseX, mouseY);
        if (this.startOfManual.isHovered())
            this.renderTooltip(matrixStack, FIRST_PAGE, mouseX, mouseY);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {

        Pair<Page, Page> pages = this.getPages();

        if(mouseY > pageY && mouseY < pageY + 144){
            if(mouseX > pageX && mouseX < pageX + Page.MAX_LINE_WIDTH){
                Page page = pages.getFirst();
                if(page != null)
                    page.onClick(mouseX - pageX, mouseY - pageY);
            }
            else if(mouseX > page2X && mouseX < page2X + Page.MAX_LINE_WIDTH){
                Page page = pages.getSecond();
                if(page != null)
                    page.onClick(mouseX - pageX, mouseY - pageY);
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    public void turnPage(boolean forward){

        //if can change page in same chapter
        Chapter currentChapter = this.getChapter();
        if(currentChapter == null){
            this.chapterIndex = 0;
            return;
        }

        if(forward){
            if(this.pageIndex + 2 < currentChapter.getPages().size()){
                this.pageIndex += 2;
            }
            //If outside the chapter
            else{
                //Try to get next chapter
                if(this.chapterIndex + 1 < this.chapters.size()){
                    this.chapterIndex += 1;
                    this.pageIndex = 0;
                }
            }
        }
        //If turning back
        else {
            //If still in chapter
            if(this.pageIndex - 2 >= 0)
                this.pageIndex -= 2;
            //if out of chapter
            else{
                //try to get the previous chapter
                if(this.chapterIndex - 1 >= 0){
                    this.chapterIndex -= 1;
                    int chapterSize = this.getChapter().getPages().size();
                    this.pageIndex = chapterSize % 2 == 0 ? chapterSize - 2 : chapterSize - 1;
                }
            }
        }

    }

    public void insertTOC(){
        Chapter chapter = this.chapters.get(0);
        if(chapter != null){
        	int maxPerPage = TOCPage.MAX_LINES;
        	int maxChapters = this.chapters.size();
        	if (maxChapters > 0) {
        		int initialPages = (int)((double)maxChapters/(double)maxPerPage);
                
                //Account for any leftover entries. If true, add an extra page
                int numPages = (int)((double)maxChapters % (double)maxPerPage) == 0 ? initialPages : initialPages + 1;
            	if (numPages > 0) {
            		int prevEndIndex = 0;
            		for (int i = 0; i < numPages; i++) {
                        int startIndex = i * maxPerPage;
                        int endIndex = startIndex + maxPerPage > maxChapters ? maxChapters - 1 : startIndex + maxPerPage;
                        if (startIndex == prevEndIndex && prevEndIndex > 0) //Don't duplicate the previous index
                            startIndex = endIndex;
                        prevEndIndex = endIndex;
                        if(!(chapter.getPages().get(i) instanceof TOCPage)){
                            chapter.insertPage(i, new TOCPage(this, startIndex, endIndex));
                        }
            		}
            	}
        	}
            
        }
    }
    
    public void turnChapter(boolean forward) {
        Chapter currentChapter = this.getChapter();
        if(currentChapter == null){
            this.chapterIndex = 0;
            return;
        }
        
        if(forward){
            if(this.chapterIndex + 1 < chapters.size()){
                this.chapterIndex += 1;
                this.pageIndex = 0;
            }
        }
        else {
            //try to get the previous chapter
            if(this.chapterIndex - 1 >= 0){
                this.chapterIndex -= 1;
                this.pageIndex = 0;
            }
        }
    }
    
    public void turnToChapter(int chapterIndex) {
        if (chapterIndex < chapters.size()) {
            this.chapterIndex = chapterIndex;
            this.pageIndex = 0;
        }
    }
    
    public void turnToTableOfContents(boolean forward) {
        if (forward) {
            int maxChapter = this.chapters.size() - 1;
            this.chapterIndex = maxChapter;
            this.pageIndex = this.chapters.get(maxChapter).getPages().size() - 1;
        }
        else {
            this.chapterIndex = 0;
            this.pageIndex = 0;
        }
    }

    public int getGlobalPageNumber(){
        int pages = 0;
        for(int i = 0; i < this.chapterIndex; ++i){
            pages += this.chapters.get(i).getPages().size();
        }
        return pages + this.pageIndex;
    }

    public Chapter getChapter(){
        if(this.chapterIndex < this.chapters.size())
            return this.chapters.get(this.chapterIndex);
        return null;
    }

    public List<Chapter> getChapters(){
        return this.chapters;
    }
    
    public int getChapterIndex() {
        return this.chapterIndex;
    }

    public Pair<Page, Page> getPages(){
        Chapter chapter = this.getChapter();
        if(chapter != null && this.pageIndex < chapter.getPages().size()){

            Page page2 = null;

            if(this.pageIndex + 1 < chapter.getPages().size())
                page2 = chapter.getPages().get(this.pageIndex + 1);

            return new Pair<Page, Page>(this.getChapter().getPages().get(this.pageIndex), page2);
        }
        return new Pair<Page, Page>(null, null);
    }
    
    public ResourceLocation getTexture() {
        return TEXTURE;
    }

    @Override
    public <T extends Widget> T addButton(T button) {
        return super.addButton(button);
    }

    private void read(){
        String localeCode = Minecraft.getInstance().getLanguageManager().getCurrentLanguage().getCode();
        ResourceLocation indexLocation = this.getManualIndexResourceLocation(localeCode);
        IResource resource = null;
        try{
            resource = getManualResourceNullable(indexLocation);
        }
        catch(IOException e){
            e.printStackTrace();
            
            Tardis.LOGGER.error("Could not find Manual resources for locale: {}, reverting to contents for locale {}", Minecraft.getInstance().getLanguageManager().getCurrentLanguage().getCode(), TardisConstants.ENGLISH_US_LOCALE);
            localeCode = TardisConstants.ENGLISH_US_LOCALE;
            indexLocation = this.getManualIndexResourceLocation(localeCode);
            try {
                resource = getManualResourceNullable(indexLocation);
            } catch (IOException exTwo) {
                exTwo.printStackTrace();
            }
        }
        
        if (resource != null) {
            JsonObject root = new JsonParser().parse(new InputStreamReader(resource.getInputStream())).getAsJsonObject();
            Index index = Index.read(indexLocation, root, localeCode);
            //Pull all chapters
            this.chapters.clear();
            this.chapters.addAll(index.getChapters());
        }
    }

    public ResourceLocation getManualIndexResourceLocation(String localeCode) {
        return Index.getIndexResourceLocation(new ResourceLocation(this.modid, "main"), localeCode);
    }
    
    private static IResource getManualResourceNullable(ResourceLocation rl) throws IOException{
        return Minecraft.getInstance().getResourceManager().getResource(rl);
    }
    
}