package litewolf101.wuffysmagicmayhem.objects.mobs.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by LiteWolf101 on 7/14/2018.
 */
@SideOnly(Side.CLIENT)
public class ModelSummonerSpike extends ModelBase{
    public final ModelRenderer base;
    public final ModelRenderer spike;


    public ModelSummonerSpike() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        //base
        this.base = new ModelRenderer(this,0,0);
        this.base.addBox(-7,10,-7,14,1,14);

        ModelRenderer cube0 = new ModelRenderer(this,80,0);
        cube0.addBox(-13,8,-3,6,6,6);
        this.base.addChild(cube0);

        ModelRenderer cube1 = new ModelRenderer(this,56,0);
        cube1.addBox(-3,8,-13,6,6,6);
        this.base.addChild(cube1);

        ModelRenderer cube2 = new ModelRenderer(this,104,0);
        cube2.addBox(7,8,-3,6,6,6);
        this.base.addChild(cube2);

        ModelRenderer cube3 = new ModelRenderer(this,0,15);
        cube3.addBox(-3,8,7,6,6,6);
        this.base.addChild(cube3);

        ModelRenderer cube4 = new ModelRenderer(this,24,15);
        cube4.addBox(-7,9,6,4,4,4);
        this.base.addChild(cube4);

        ModelRenderer cube5 = new ModelRenderer(this,40,15);
        cube5.addBox(-10,9,3,4,4,4);
        this.base.addChild(cube5);

        ModelRenderer cube6 = new ModelRenderer(this,56,15);
        cube6.addBox(-10,9,-7,4,4,4);
        this.base.addChild(cube6);

        ModelRenderer cube7 = new ModelRenderer(this,16,27);
        cube7.addBox(-7,9,-10,4,4,4);
        this.base.addChild(cube7);

        ModelRenderer cube8 = new ModelRenderer(this,32,27);
        cube8.addBox(3,9,-10,4,4,4);
        this.base.addChild(cube8);

        ModelRenderer cube9 = new ModelRenderer(this,48,27);
        cube9.addBox(6,9,-7,4,4,4);
        this.base.addChild(cube9);

        ModelRenderer cube10 = new ModelRenderer(this,0,35);
        cube10.addBox(6,9,3,4,4,4);
        this.base.addChild(cube10);

        ModelRenderer cube11 = new ModelRenderer(this,0,27);
        cube11.addBox(3,9,6,4,4,4);
        this.base.addChild(cube11);
        //spike
        this.spike = new ModelRenderer(this,16,35);
        this.spike.addBox(-0.5F,10,-0.5F,1,24,1);

        ModelRenderer spike1 = new ModelRenderer(this,0,60);
        spike1.addBox(-1,9,-1,2,1,2);
        this.spike.addChild(spike1);

        ModelRenderer spike2 = new ModelRenderer(this,8,60);
        spike2.addBox(-3,8,-2,6,1,4);
        this.spike.addChild(spike2);

        ModelRenderer spike3 = new ModelRenderer(this,0,65);
        spike3.addBox(-2,8,-3,4,1,6);
        this.spike.addChild(spike3);

        ModelRenderer spike4 = new ModelRenderer(this,28,60);
        spike4.addBox(-2,7,-2,4,1,4);
        this.spike.addChild(spike4);

        ModelRenderer spike5 = new ModelRenderer(this,20,38);
        spike5.addBox(-1.5F,6,-1.5F,3,1,3);
        this.spike.addChild(spike5);

        ModelRenderer spike6 = new ModelRenderer(this,20,35);
        spike6.addBox(-1,5,-1,2,1,2);
        this.spike.addChild(spike6);

        ModelRenderer spike7 = new ModelRenderer(this,44,60);
        spike7.addBox(-0.5F,4,-0.5F,1,1,1);
        this.spike.addChild(spike7);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {


        this.spike.rotationPointY = this.base.rotationPointY;
        float f1 = (limbSwing + MathHelper.sin(limbSwing * 4.7F)) * 1.8F * 10.0F;
        float f2 = (limbSwing + MathHelper.sin(limbSwing * 4.7F)) * 2.8F * 1.0F;
        this.spike.rotationPointY = 10.0F - f1;
        this.base.rotationPointY = 2.5F - f2;


        this.base.render(scale);
        this.spike.render(scale);
    }
}
