/*
 *       Copyright (C) 2018-present Hyperium <https://hyperium.cc/>
 *
 *       This program is free software: you can redistribute it and/or modify
 *       it under the terms of the GNU Lesser General Public License as published
 *       by the Free Software Foundation, either version 3 of the License, or
 *       (at your option) any later version.
 *
 *       This program is distributed in the hope that it will be useful,
 *       but WITHOUT ANY WARRANTY; without even the implied warranty of
 *       MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *       GNU Lesser General Public License for more details.
 *
 *       You should have received a copy of the GNU Lesser General Public License
 *       along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package cc.hyperium.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

public class GuiIngameMultiplayer extends GuiMultiplayer {

    public GuiIngameMultiplayer(GuiScreen parentScreen) {
        super(parentScreen);
    }

    /*
           Ported by KodingKing
           Original mod by Canelex
    */

    public void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 1 || button.id == 4) {
            dc();
        }
        super.actionPerformed(button);
    }

    public void connectToSelected() {
        dc();
        super.connectToSelected();
    }

    private void dc() {
        if (Minecraft.getMinecraft().theWorld != null) {
            Minecraft.getMinecraft().theWorld.sendQuittingDisconnectingPacket();
            Minecraft.getMinecraft().loadWorld(null);
            mc.displayGuiScreen(null);
        }
    }
}
