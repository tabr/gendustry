/*
 * Copyright (c) bdew, 2013 - 2014
 * https://github.com/bdew/gendustry
 *
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://bdew.net/minecraft-mod-public-license/
 */

package net.bdew.gendustry.machines.sampler

import net.bdew.gendustry.Gendustry
import net.bdew.gendustry.gui.{HintIcons, Textures, WidgetPowerCustom, WidgetProgressBarNEI}
import net.bdew.lib.Misc
import net.bdew.lib.gui.widgets.WidgetLabel
import net.bdew.lib.gui.{BaseScreen, Color, Rect, Texture}
import net.minecraft.entity.player.EntityPlayer

class GuiSampler(val te: TileSampler, player: EntityPlayer) extends BaseScreen(new ContainerSampler(te, player), 176, 166) {
  val background = Texture(Gendustry.modId, "textures/gui/sampler.png", rect)

  override def initGui() {
    super.initGui()
    widgets.add(new WidgetProgressBarNEI(new Rect(63, 49, 66, 15), Textures.whiteProgress(66), te.progress, "Sampler"))
    widgets.add(new WidgetPowerCustom(new Rect(8, 19, 16, 58), Textures.powerFill, te.power))
    widgets.add(new WidgetLabel(Misc.toLocal("tile.gendustry.sampler.name"), 8, 6, Color.darkGray))

    inventorySlots.getSlotFromInventory(te, te.slots.inSampleBlank).setBackgroundIcon(HintIcons.blankSample)
    inventorySlots.getSlotFromInventory(te, te.slots.inLabware).setBackgroundIcon(HintIcons.labware)
    inventorySlots.getSlotFromInventory(te, te.slots.inIndividual).setBackgroundIcon(HintIcons.droneOrSapling)
    inventorySlots.getSlotFromInventory(te, te.slots.outSample).setBackgroundIcon(HintIcons.sample)
  }
}