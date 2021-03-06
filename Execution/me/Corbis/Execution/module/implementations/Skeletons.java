package me.Corbis.Execution.module.implementations;

import me.Corbis.Execution.event.EventTarget;
import me.Corbis.Execution.event.events.Event3D;
import me.Corbis.Execution.module.Category;
import me.Corbis.Execution.module.Module;
import me.Corbis.Execution.utils.RenderingUtil;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.Map;

public class Skeletons extends Module {

    private static Map<EntityPlayer, float[][]> entities = new HashMap<>();

    public Skeletons(){
        super("Skeletons", Keyboard.KEY_NONE, Category.RENDER);
    }

    @EventTarget
    public void on3D(Event3D event){
        startEnd(true);
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glDisable(2848);
        entities.keySet().removeIf(this::doesntContain);
        getMc().theWorld.playerEntities.forEach(player -> drawSkeleton(event, player));
        Gui.drawRect(0, 0, 0, 0, 0);
        startEnd(false);
    }

    private void drawSkeleton(Event3D event, EntityPlayer e) {
        if (!e.isInvisible()) {
            float[][] entPos = entities.get(e);
            if (entPos != null && e.getEntityId() != -1488 && e.isEntityAlive() &&!AntiBot.isBot(e) && RenderingUtil.isInViewFrustrum(e) && !e.isDead && e != getMc().thePlayer && !e.isPlayerSleeping()) {
                GL11.glPushMatrix();
                GL11.glEnable(GL11.GL_LINE_SMOOTH);
                GL11.glLineWidth(2);
                GlStateManager.color(1,1,1, 1);
                Vec3 vec = getVec3(event, e);
                double x = vec.xCoord - getMc().getRenderManager().getRenderPosX();
                double y = vec.yCoord - getMc().getRenderManager().getRenderPosY();
                double z = vec.zCoord - getMc().getRenderManager().getRenderPosZ();
                GL11.glTranslated(x, y, z);
                float xOff = e.prevRenderYawOffset + (e.renderYawOffset - e.prevRenderYawOffset) * event.getPartialTicks();
                GL11.glRotatef(-xOff, 0.0F, 1.0F, 0.0F);
                GL11.glTranslated(0.0D, 0.0D, e.isSneaking() ? -0.235D : 0.0D);
                float yOff = e.isSneaking() ? 0.6F : 0.75F;
                GL11.glPushMatrix();
                GlStateManager.color(1,1,1, 1);
                GL11.glTranslated(-0.125D, yOff, 0.0D);
                if (entPos[3][0] != 0.0F) {
                    GL11.glRotatef(entPos[3][0] * 57.295776F, 1.0F, 0.0F, 0.0F);
                }

                if (entPos[3][1] != 0.0F) {
                    GL11.glRotatef(entPos[3][1] * 57.295776F, 0.0F, 1.0F, 0.0F);
                }

                if (entPos[3][2] != 0.0F) {
                    GL11.glRotatef(entPos[3][2] * 57.295776F, 0.0F, 0.0F, 1.0F);
                }

                GL11.glBegin(3);
                GL11.glVertex3d(0.0D, 0.0D, 0.0D);
                GL11.glVertex3d(0.0D, (-yOff), 0.0D);
                GL11.glEnd();
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GlStateManager.color(1,1,1, 1);
                GL11.glTranslated(0.125D, yOff, 0.0D);
                if (entPos[4][0] != 0.0F) {
                    GL11.glRotatef(entPos[4][0] * 57.295776F, 1.0F, 0.0F, 0.0F);
                }

                if (entPos[4][1] != 0.0F) {
                    GL11.glRotatef(entPos[4][1] * 57.295776F, 0.0F, 1.0F, 0.0F);
                }

                if (entPos[4][2] != 0.0F) {
                    GL11.glRotatef(entPos[4][2] * 57.295776F, 0.0F, 0.0F, 1.0F);
                }

                GL11.glBegin(3);
                GL11.glVertex3d(0.0D, 0.0D, 0.0D);
                GL11.glVertex3d(0.0D, (-yOff), 0.0D);
                GL11.glEnd();
                GL11.glPopMatrix();
                GL11.glTranslated(0.0D, 0.0D, e.isSneaking() ? 0.25D : 0.0D);
                GL11.glPushMatrix();
                GlStateManager.color(1,1,1, 1);
                GL11.glTranslated(0.0D, e.isSneaking() ? -0.05D : 0.0D, e.isSneaking() ? -0.01725D : 0.0D);
                GL11.glPushMatrix();
                GlStateManager.color(1,1,1, 1);
                GL11.glTranslated(-0.375D, yOff + 0.55D, 0.0D);
                if (entPos[1][0] != 0.0F) {
                    GL11.glRotatef(entPos[1][0] * 57.295776F, 1.0F, 0.0F, 0.0F);
                }

                if (entPos[1][1] != 0.0F) {
                    GL11.glRotatef(entPos[1][1] * 57.295776F, 0.0F, 1.0F, 0.0F);
                }

                if (entPos[1][2] != 0.0F) {
                    GL11.glRotatef(-entPos[1][2] * 57.295776F, 0.0F, 0.0F, 1.0F);
                }

                GL11.glBegin(3);
                GL11.glVertex3d(0.0D, 0.0D, 0.0D);
                GL11.glVertex3d(0.0D, -0.5D, 0.0D);
                GL11.glEnd();
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glTranslated(0.375D, yOff + 0.55D, 0.0D);
                if (entPos[2][0] != 0.0F) {
                    GL11.glRotatef(entPos[2][0] * 57.295776F, 1.0F, 0.0F, 0.0F);
                }

                if (entPos[2][1] != 0.0F) {
                    GL11.glRotatef(entPos[2][1] * 57.295776F, 0.0F, 1.0F, 0.0F);
                }

                if (entPos[2][2] != 0.0F) {
                    GL11.glRotatef(-entPos[2][2] * 57.295776F, 0.0F, 0.0F, 1.0F);
                }

                GL11.glBegin(3);
                GL11.glVertex3d(0.0D, 0.0D, 0.0D);
                GL11.glVertex3d(0.0D, -0.5D, 0.0D);
                GL11.glEnd();
                GL11.glPopMatrix();
                GL11.glRotatef(xOff - e.rotationYawHead, 0.0F, 1.0F, 0.0F);
                GL11.glPushMatrix();
                GlStateManager.color(1,1,1, 1);
                GL11.glTranslated(0.0D, yOff + 0.55D, 0.0D);
                if (entPos[0][0] != 0.0F) {
                    GL11.glRotatef(entPos[0][0] * 57.295776F, 1.0F, 0.0F, 0.0F);
                }

                GL11.glBegin(3);
                GL11.glVertex3d(0.0D, 0.0D, 0.0D);
                GL11.glVertex3d(0.0D, 0.3D, 0.0D);
                GL11.glEnd();
                GL11.glPopMatrix();
                GL11.glPopMatrix();
                GL11.glRotatef(e.isSneaking() ? 25.0F : 0.0F, 1.0F, 0.0F, 0.0F);
                GL11.glTranslated(0.0D, e.isSneaking() ? -0.16175D : 0.0D, e.isSneaking() ? -0.48025D : 0.0D);
                GL11.glPushMatrix();
                GL11.glTranslated(0.0D, yOff, 0.0D);
                GL11.glBegin(3);
                GL11.glVertex3d(-0.125D, 0.0D, 0.0D);
                GL11.glVertex3d(0.125D, 0.0D, 0.0D);
                GL11.glEnd();
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GlStateManager.color(1,1,1, 1);
                GL11.glTranslated(0.0D, yOff, 0.0D);
                GL11.glBegin(3);
                GL11.glVertex3d(0.0D, 0.0D, 0.0D);
                GL11.glVertex3d(0.0D, 0.55D, 0.0D);
                GL11.glEnd();
                GL11.glPopMatrix();
                GL11.glPushMatrix();
                GL11.glTranslated(0.0D, yOff + 0.55D, 0.0D);
                GL11.glBegin(3);
                GL11.glVertex3d(-0.375D, 0.0D, 0.0D);
                GL11.glVertex3d(0.375D, 0.0D, 0.0D);
                GL11.glEnd();
                GL11.glPopMatrix();
                GL11.glPopMatrix();
            }
        }
    }

    private Vec3 getVec3(Event3D event, EntityPlayer var0) {
        float pt = event.getPartialTicks();
        double x = var0.lastTickPosX + (var0.posX - var0.lastTickPosX) * pt;
        double y = var0.lastTickPosY + (var0.posY - var0.lastTickPosY) * pt;
        double z = var0.lastTickPosZ + (var0.posZ - var0.lastTickPosZ) * pt;
        return new Vec3(x, y, z);
    }

    public static void addEntity(EntityPlayer e, ModelPlayer model) {
        entities.put(e, new float[][]{{model.bipedHead.rotateAngleX, model.bipedHead.rotateAngleY, model.bipedHead.rotateAngleZ}, {model.bipedRightArm.rotateAngleX, model.bipedRightArm.rotateAngleY, model.bipedRightArm.rotateAngleZ}, {model.bipedLeftArm.rotateAngleX, model.bipedLeftArm.rotateAngleY, model.bipedLeftArm.rotateAngleZ}, {model.bipedRightLeg.rotateAngleX, model.bipedRightLeg.rotateAngleY, model.bipedRightLeg.rotateAngleZ}, {model.bipedLeftLeg.rotateAngleX, model.bipedLeftLeg.rotateAngleY, model.bipedLeftLeg.rotateAngleZ}});
    }

    private boolean doesntContain(EntityPlayer var0) {
        return !getMc().theWorld.playerEntities.contains(var0);
    }

    private void startEnd(boolean revert) {
        if (revert) {
            GlStateManager.pushMatrix();
            GlStateManager.enableBlend();
            GL11.glEnable(2848);
            GlStateManager.disableDepth();
            GlStateManager.disableTexture2D();
            GL11.glHint(3154, 4354);
        } else {
            GlStateManager.disableBlend();
            GlStateManager.enableTexture2D();
            GL11.glDisable(2848);
            GlStateManager.enableDepth();
            GlStateManager.popMatrix();
        }
        GlStateManager.depthMask(!revert);
    }
}
