/*
 * Minecraft Forge
 * Copyright (c) 2016-2021.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.tadditions.mod.helper;

import com.google.gson.JsonObject;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.tadditions.mod.config.MConfigs;

public final class TrueConCondition implements ICondition
{
    public static final TrueConCondition INSTANCE = new TrueConCondition();
    private static final ResourceLocation NAME = new ResourceLocation("tadditions", "true");

    private TrueConCondition() {}


    @Override
    public ResourceLocation getID() {
        return NAME;
    }

    @Override
    public boolean test()
    {
        return MConfigs.SERVER.StattenheimRecipe.get();
    }

    @Override
    public String toString()
    {
        return NAME.toString();
    }

    public static class Serializer implements IConditionSerializer<TrueConCondition>
    {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void write(JsonObject json, TrueConCondition value) { }

        @Override
        public TrueConCondition read(JsonObject json)
        {
            return TrueConCondition.INSTANCE;
        }

        @Override
        public ResourceLocation getID()
        {
            return new ResourceLocation("tadditions", "true");
        }
    }
}
