package litewolf101.wuffysmagicmayhem.mobs.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by LiteWolf101 on 6/27/2018.
 */
@SideOnly(Side.CLIENT)
public class ModelFloatingStar extends ModelBase{
    public final ModelRenderer starBody;

    public ModelFloatingStar(){
        this.textureWidth = 32;
        this.textureHeight = 32;
        //starBody
        this.starBody = new ModelRenderer(this, 0, 0);
        this.starBody.addBox(-2, 6, -2, 4, 4, 4);
        //longboxY
        ModelRenderer longboxY = new ModelRenderer(this, 16, 0);
        longboxY.addBox(-1, 5, -1, 2, 6, 2);
        this.starBody.addChild(longboxY);
        //longboxX
        ModelRenderer longboxX = new ModelRenderer(this, 0, 8);
        longboxX.addBox(-3, 7, -1, 6, 2, 2);
        this.starBody.addChild(longboxX);
        //longboxZ
        ModelRenderer longboxZ = new ModelRenderer(this, 16, 8);
        longboxZ.addBox(-1, 7, -3, 2, 2, 6);
        this.starBody.addChild(longboxZ);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.starBody.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.starBody.rotateAngleX = headPitch * 0.017453292F;
        this.starBody.rotateAngleY = netHeadYaw * 0.017453292F;
        this.starBody.rotateAngleZ = 0.0F;
        this.starBody.setRotationPoint(0.0F, 0.0F, 0.0F);
    }
}
