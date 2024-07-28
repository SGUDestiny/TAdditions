package net.tadditions.mod.helper;

import net.tardis.mod.client.models.interiordoors.IInteriorDoorRenderer;
import net.tardis.mod.enums.EnumDoorState;
import net.tardis.mod.misc.IDoorType;

import java.util.function.Function;
import java.util.function.Supplier;

public interface IMDoorType {
    /** Get all door states for this interior door. Can be called on both sides*/
    EnumDoorState[] getValidStates();

    /** For client side rendering only. Units are in Degrees */
    double getRotationForState(EnumDoorState state);
    /** Call in FMLClientSetupEvent only */
    void setInteriorDoorModel(IInteriorDoorRenderer renderer);
    /** Only call on the logical CLIENT Side*/
    IInteriorDoorRenderer getInteriorDoorRenderer();

    public static enum EnumDoorType implements IDoorType {

        TOYOTA((state) -> {
            switch (state) {
                case CLOSED:
                    return 0.0;
                case ONE:
                    return 70.0;
                case BOTH:
                    return -70.0;
                default:
                    return 0.0;
            }
        }, EnumDoorState.CLOSED, EnumDoorState.ONE, EnumDoorState.BOTH),

        FOURTEENTH((state) -> {
            switch (state) {
                case CLOSED:
                    return 0.0;
                case ONE:
                    return 70.0;
                case BOTH:
                    return -70.0;
                default:
                    return 0.0;
            }
        }, EnumDoorState.CLOSED, EnumDoorState.ONE, EnumDoorState.BOTH),

        CORAL((state) -> {
            switch (state) {
                case CLOSED:
                    return 0.0;
                case ONE:
                    return 70.0;
                case BOTH:
                    return -70.0;
                default:
                    return 0.0;
            }
        }, EnumDoorState.CLOSED, EnumDoorState.ONE, EnumDoorState.BOTH);

        Function<EnumDoorState, Double> func;
        EnumDoorState[] validStates;
        Supplier<Supplier<IInteriorDoorRenderer>> renderer;

        EnumDoorType(Function<EnumDoorState, Double> func, EnumDoorState... states) {
            this.validStates = states;
            this.func = func;
        }

        @Override
        public EnumDoorState[] getValidStates() {
            return this.validStates;
        }

        @Override
        public double getRotationForState(EnumDoorState state) {
            return func.apply(state);
        }

        @Override
        public void setInteriorDoorModel(IInteriorDoorRenderer renderer) {
            this.renderer = () -> () -> renderer;
        }

        @Override
        public IInteriorDoorRenderer getInteriorDoorRenderer() {
            return this.renderer.get().get();
        }

    }
}
