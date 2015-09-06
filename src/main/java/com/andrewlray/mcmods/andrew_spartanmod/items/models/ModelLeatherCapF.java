package com.andrewlray.mcmods.andrew_spartanmod.items.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLeatherCapF extends ModelBiped {
	// fields
	ModelRenderer CapTop;
	ModelRenderer CapBack;
	ModelRenderer CapLeft;
	ModelRenderer CapRight;
	ModelRenderer CapFrontA;
	ModelRenderer CapFrontL;
	ModelRenderer CapFrontR;
	ModelRenderer FeatherF;
	ModelRenderer FeatherB;
	ModelRenderer FeatherE;
	ModelRenderer FeatherC;
	ModelRenderer FeatherA;
	ModelRenderer FeatherD;
	ModelRenderer FeatherG;

	public ModelLeatherCapF(float expand) {
		super(expand, 0, 64, 64);

		CapTop = new ModelRenderer(this, 0, 53);
		CapTop.addBox(-5F, -9F, -5F, 10, 1, 10);
		CapTop.setRotationPoint(0F, 0F, 0F);
		CapTop.setTextureSize(64, 64);
		CapTop.mirror = true;
		setRotation(CapTop, 0F, 0F, 0F);
		
		CapBack = new ModelRenderer(this, 18, 48);
		CapBack.addBox(-4F, -8F, 4F, 8, 4, 1);
		CapBack.setRotationPoint(0F, 0F, 0F);
		CapBack.setTextureSize(64, 64);
		CapBack.mirror = true;
		setRotation(CapBack, 0F, 0F, 0F);
		
		CapLeft = new ModelRenderer(this, 42, 50);
		CapLeft.addBox(-5F, -8F, -5F, 1, 4, 10);
		CapLeft.setRotationPoint(0F, 0F, 0F);
		CapLeft.setTextureSize(64, 64);
		CapLeft.mirror = true;
		setRotation(CapLeft, 0F, 0F, 0F);
		
		CapRight = new ModelRenderer(this, 42, 50);
		CapRight.addBox(4F, -8F, -5F, 1, 4, 10);
		CapRight.setRotationPoint(0F, 0F, 0F);
		CapRight.setTextureSize(64, 64);
		CapRight.mirror = true;
		setRotation(CapRight, 0F, 0F, 0F);
		
		CapFrontA = new ModelRenderer(this, 0, 50);
		CapFrontA.addBox(-4F, -8F, -5F, 8, 2, 1);
		CapFrontA.setRotationPoint(0F, 0F, 0F);
		CapFrontA.setTextureSize(64, 64);
		CapFrontA.mirror = true;
		setRotation(CapFrontA, 0F, 0F, 0F);
		
		CapFrontL = new ModelRenderer(this, 0, 48);
		CapFrontL.addBox(-4F, -6F, -5F, 1, 1, 1);
		CapFrontL.setRotationPoint(0F, 0F, 0F);
		CapFrontL.setTextureSize(64, 64);
		CapFrontL.mirror = true;
		setRotation(CapFrontL, 0F, 0F, 0F);
		
		CapFrontR = new ModelRenderer(this, 0, 48);
		CapFrontR.addBox(3F, -6F, -5F, 1, 1, 1);
		CapFrontR.setRotationPoint(0F, 0F, 0F);
		CapFrontR.setTextureSize(64, 64);
		CapFrontR.mirror = true;
		setRotation(CapFrontR, 0F, 0F, 0F);
		
		FeatherF = new ModelRenderer(this, 4, 43);
		FeatherF.addBox(-5.5F, -13F, 1F, 1, 1, 6);
		FeatherF.setRotationPoint(0F, 0F, 0F);
		FeatherF.setTextureSize(64, 64);
		FeatherF.mirror = true;
		setRotation(FeatherF, 0F, 0F, 0F);
		
		FeatherB = new ModelRenderer(this, 8, 45);
		FeatherB.addBox(-5.5F, -10F, -3F, 1, 2, 2);
		FeatherB.setRotationPoint(0F, 0F, 0F);
		FeatherB.setTextureSize(64, 64);
		FeatherB.mirror = true;
		setRotation(FeatherB, 0F, 0F, 0F);
		
		FeatherE = new ModelRenderer(this, 0, 41);
		FeatherE.addBox(-5.5F, -12F, -1F, 1, 1, 6);
		FeatherE.setRotationPoint(0F, 0F, 0F);
		FeatherE.setTextureSize(64, 64);
		FeatherE.mirror = true;
		setRotation(FeatherE, 0F, 0F, 0F);
		
		FeatherC = new ModelRenderer(this, 0, 46);
		FeatherC.addBox(-5.5F, -10F, -1F, 1, 1, 1);
		FeatherC.setRotationPoint(0F, 0F, 0F);
		FeatherC.setTextureSize(64, 64);
		FeatherC.mirror = true;
		setRotation(FeatherC, 0F, 0F, 0F);
		
		FeatherA = new ModelRenderer(this, 4, 48);
		FeatherA.addBox(-5.5F, -8F, -4F, 1, 1, 1);
		FeatherA.setRotationPoint(0F, 0F, 0F);
		FeatherA.setTextureSize(64, 64);
		FeatherA.mirror = true;
		setRotation(FeatherA, 0F, 0F, 0F);
		
		FeatherD = new ModelRenderer(this, 0, 36);
		FeatherD.addBox(-5.5F, -11F, -2F, 1, 1, 4);
		FeatherD.setRotationPoint(0F, 0F, 0F);
		FeatherD.setTextureSize(64, 64);
		FeatherD.mirror = true;
		setRotation(FeatherD, 0F, 0F, 0F);
		
		FeatherG = new ModelRenderer(this, 0, 35);
		FeatherG.addBox(-5.5F, -14F, 2F, 1, 1, 3);
		FeatherG.setRotationPoint(0F, 0F, 0F);
		FeatherG.setTextureSize(64, 64);
		FeatherG.mirror = true;
		setRotation(FeatherG, 0F, 0F, 0F);
		
		this.bipedHead.addChild(CapTop);
		this.bipedHead.addChild(CapBack);
		this.bipedHead.addChild(CapLeft);
		this.bipedHead.addChild(CapRight);
		this.bipedHead.addChild(CapFrontA);
		this.bipedHead.addChild(CapFrontL);
		this.bipedHead.addChild(CapFrontR);
		this.bipedHead.addChild(FeatherA);
		FeatherA.addChild(FeatherB);
		FeatherB.addChild(FeatherC);
		FeatherC.addChild(FeatherD);
		FeatherD.addChild(FeatherE);
		FeatherE.addChild(FeatherF);
		FeatherF.addChild(FeatherG);
	}

	/*
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		CapTop.render(f5);
		CapBack.render(f5);
		CapLeft.render(f5);
		CapRight.render(f5);
		CapFrontA.render(f5);
		CapFrontL.render(f5);
		CapFrontR.render(f5);
		FeatherF.render(f5);
		FeatherB.render(f5);
		FeatherE.render(f5);
		FeatherC.render(f5);
		FeatherA.render(f5);
		FeatherD.render(f5);
		FeatherG.render(f5);
	} */

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
