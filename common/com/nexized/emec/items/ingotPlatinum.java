package com.nexized.emec.items;

import com.nexized.emec.lib.modInfo;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ingotPlatinum extends Item {

	public ingotPlatinum(int par1)
    {
        super(par1);
        this.setMaxStackSize(64);
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
	
	public void registerIcons(IconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(modInfo.MODID + ":ingotPlatinum");
    }
	
}
