package net.tadditions.mod.screens.misc;

public enum AdvQuantiscopeScreenType {

    WELD(null);

    private AdvQuantiscopeSlotMapper mapper;

    AdvQuantiscopeScreenType(AdvQuantiscopeSlotMapper mapper){
        this.mapper = mapper;
    }

    public AdvQuantiscopeSlotMapper getSlotMapper(){
        return this.mapper;
    }

}
