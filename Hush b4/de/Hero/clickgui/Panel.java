// 
// Decompiled by Procyon v0.5.36
// 

package de.Hero.clickgui;

import java.util.Iterator;
import de.Hero.clickgui.util.FontUtil;
import me.nico.hush.Client;
import net.minecraft.client.gui.Gui;
import java.awt.Color;
import de.Hero.clickgui.util.ColorUtil;
import de.Hero.clickgui.elements.ModuleButton;
import java.util.ArrayList;

public class Panel
{
    public String title;
    public double x;
    public double y;
    private double x2;
    private double y2;
    public double width;
    public double height;
    public boolean dragging;
    public boolean extended;
    public boolean visible;
    public ArrayList<ModuleButton> Elements;
    public ClickGUI clickgui;
    
    public Panel(final String ititle, final double ix, final double iy, final double iwidth, final double iheight, final boolean iextended, final ClickGUI parent) {
        this.Elements = new ArrayList<ModuleButton>();
        this.title = ititle;
        this.x = ix;
        this.y = iy;
        this.width = iwidth;
        this.height = iheight;
        this.extended = iextended;
        this.dragging = false;
        this.visible = true;
        this.clickgui = parent;
        this.setup();
    }
    
    public void setup() {
    }
    
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        if (!this.visible) {
            return;
        }
        if (this.dragging) {
            this.x = this.x2 + mouseX;
            this.y = this.y2 + mouseY;
        }
        final Color temp = ColorUtil.getClickGUIColor().darker();
        final int outlineColor = new Color(temp.getRed(), temp.getGreen(), temp.getBlue(), 170).getRGB();
        Gui.drawRect(this.x, this.y, this.x + this.width, this.y + this.height, -2130706432);
        if (Client.instance.settingManager.getSettingByName("Design").getValString().equalsIgnoreCase("Hero")) {
            Gui.drawRect(this.x - 2.0, this.y, this.x, this.y + this.height, outlineColor);
            FontUtil.drawStringWithShadow(this.title, this.x + 2.0, this.y + this.height / 2.0 - FontUtil.getFontHeight() / 2, -1052689);
        }
        else if (Client.instance.settingManager.getSettingByName("Design").getValString().equalsIgnoreCase("Zodiac")) {
            Gui.drawRect(this.x + 4.0, this.y + 2.0, this.x + 4.3, this.y + this.height - 2.0, 16777215);
            Gui.drawRect(this.x - 4.0 + this.width, this.y + 2.0, this.x - 4.3 + this.width, this.y + this.height - 2.0, 16777215);
            FontUtil.drawTotalCenteredStringWithShadow("\u267e " + this.title + " \u267e", this.x + this.width / 2.0, this.y + this.height / 2.0, -1052689);
        }
        if (this.extended && !this.Elements.isEmpty()) {
            double startY = this.y + this.height;
            final int epanelcolor = Client.instance.settingManager.getSettingByName("Design").getValString().equalsIgnoreCase("Hero") ? -14474461 : (Client.instance.settingManager.getSettingByName("Design").getValString().equalsIgnoreCase("Zodiac") ? -2130706432 : 0);
            for (final ModuleButton et : this.Elements) {
                if (Client.instance.settingManager.getSettingByName("Design").getValString().equalsIgnoreCase("Hero")) {
                    Gui.drawRect(this.x - 2.0, startY, this.x + this.width, startY + et.height + 1.0, outlineColor);
                }
                Gui.drawRect(this.x, startY, this.x + this.width, startY + et.height + 1.0, epanelcolor);
                et.x = this.x + 2.0;
                et.y = startY;
                et.width = this.width - 4.0;
                et.drawScreen(mouseX, mouseY, partialTicks);
                startY += et.height + 1.0;
            }
            Gui.drawRect(this.x, startY + 1.0, this.x + this.width, startY + 1.0, epanelcolor);
        }
    }
    
    public boolean mouseClicked(final int mouseX, final int mouseY, final int mouseButton) {
        if (!this.visible) {
            return false;
        }
        if (mouseButton == 0 && this.isHovered(mouseX, mouseY)) {
            this.x2 = this.x - mouseX;
            this.y2 = this.y - mouseY;
            return this.dragging = true;
        }
        if (mouseButton == 1 && this.isHovered(mouseX, mouseY)) {
            this.extended = !this.extended;
            return true;
        }
        if (this.extended) {
            for (final ModuleButton et : this.Elements) {
                if (et.mouseClicked(mouseX, mouseY, mouseButton)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void mouseReleased(final int mouseX, final int mouseY, final int state) {
        if (!this.visible) {
            return;
        }
        if (state == 0) {
            this.dragging = false;
        }
    }
    
    public boolean isHovered(final int mouseX, final int mouseY) {
        return mouseX >= this.x && mouseX <= this.x + this.width && mouseY >= this.y && mouseY <= this.y + this.height;
    }
}
