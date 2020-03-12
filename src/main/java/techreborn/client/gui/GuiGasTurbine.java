/*
 * This file is part of TechReborn, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2020 TechReborn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package techreborn.client.gui;

import net.minecraft.entity.player.PlayerEntity;
import reborncore.client.screen.builder.BuiltScreenHandler;
import reborncore.client.gui.builder.GuiBase;
import reborncore.client.gui.guibuilder.GuiBuilder;
import techreborn.blockentity.generator.advanced.GasTurbineBlockEntity;

public class GuiGasTurbine extends GuiBase<BuiltScreenHandler> {

	GasTurbineBlockEntity blockEntity;

	public GuiGasTurbine(int syncID, final PlayerEntity player, final GasTurbineBlockEntity blockEntity) {
		super(player, blockEntity, blockEntity.createScreenHandler(syncID, player));
		this.blockEntity = blockEntity;
	}
	
	@Override
	protected void drawBackground(final float f, final int mouseX, final int mouseY) {
		super.drawBackground(f, mouseX, mouseY);
		final GuiBase.Layer layer = GuiBase.Layer.BACKGROUND;
		drawSlot(25, 35, layer);
		drawSlot(25, 55, layer);
		builder.drawJEIButton(this, 158, 5, layer);
	}
	
	
	@Override
	protected void drawForeground(final int mouseX, final int mouseY) {
		super.drawForeground(mouseX, mouseY);
		final GuiBase.Layer layer = GuiBase.Layer.FOREGROUND;
		
		builder.drawProgressBar(this, blockEntity.getProgressScaled(10), 100, 83, 48, mouseX, mouseY, GuiBuilder.ProgressDirection.RIGHT, layer);
		builder.drawMultiEnergyBar(this, 130, 28, (int) blockEntity.getEnergy(), (int) blockEntity.getMaxPower(), mouseX, mouseY, 0, layer);
		builder.drawTank(this, 44, 25, mouseX, mouseY, blockEntity.tank.getFluidInstance(), blockEntity.tank.getCapacity(), blockEntity.tank.isEmpty(), layer);
		
	}
}
