package litewolf101.wuffysmagicmayhem.objects.mobs.model;

import litewolf101.wuffysmagicmayhem.objects.mobs.MobDarkenedKnight;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by LiteWolf101 on 7/12/2018.
 */
@SideOnly(Side.CLIENT)
public class ModelDarkenedKnight extends ModelBase {
    public boolean isHolding;
    public ItemStack itemStack;

    public final ModelRenderer dKnightHead;
    public final ModelRenderer dKnightBody;
    public final ModelRenderer dKnightLeftArm;
    public final ModelRenderer dKnightRghtArm;

    public ModelDarkenedKnight() {
        this.textureWidth = 80;
        this.textureHeight = 80;
        //head
        this.dKnightHead = new ModelRenderer(this, 0, 0);
        this.dKnightHead.addBox(-4, -7, -4, 8, 8, 8);
        //armorPlates
        ModelRenderer helmet0 = new ModelRenderer(this, 32, 7);
        helmet0.addBox(1, -4, -5, 4, 6, 1);
        this.dKnightHead.addChild(helmet0);

        ModelRenderer helmet1 = new ModelRenderer(this, 32, 0);
        helmet1.addBox(-5, -4, -5, 4, 6 ,1);
        this.dKnightHead.addChild(helmet1);

        ModelRenderer helmet2 = new ModelRenderer(this, 0, 16);
        helmet2.addBox(3, -5, -5, 2, 1,1);
        this.dKnightHead.addChild(helmet2);

        ModelRenderer helmet3 = new ModelRenderer(this, 32, 14);
        helmet3.addBox(-5, -5, -5, 2, 1, 1);
        this.dKnightHead.addChild(helmet3);

        ModelRenderer helmet4 = new ModelRenderer(this, 0, 18);
        helmet4.addBox(-5, -8, -5, 10, 3, 1);
        this.dKnightHead.addChild(helmet4);

        ModelRenderer helmet5 = new ModelRenderer(this, 34, 16);
        helmet5.addBox(4, -8, -4, 1,10,5);
        this.dKnightHead.addChild(helmet5);

        ModelRenderer helmet6 = new ModelRenderer(this, 22, 16);
        helmet6.addBox(-5, -8, -4,1,10,5);
        this.dKnightHead.addChild(helmet6);

        ModelRenderer helmet7 = new ModelRenderer(this, 4, 31);
        helmet7.addBox(4,-8,1,1,9,1);
        this.dKnightHead.addChild(helmet7);

        ModelRenderer helmet8 = new ModelRenderer(this,0,31);
        helmet8.addBox(-5,-8,1,1,9,1);
        this.dKnightHead.addChild(helmet8);

        ModelRenderer helmet9 = new ModelRenderer(this, 12, 31);
        helmet9.addBox(4,-8,2,1,8,1);
        this.dKnightHead.addChild(helmet9);

        ModelRenderer helmet10 = new ModelRenderer(this, 8, 31);
        helmet10.addBox(-5,-8,2,1,8,1);
        this.dKnightHead.addChild(helmet10);

        ModelRenderer helmet11 = new ModelRenderer(this, 6, 41);
        helmet11.addBox(4,-8,3,1,7,2);
        this.dKnightHead.addChild(helmet11);

        ModelRenderer helmet12 = new ModelRenderer(this, 0, 41);
        helmet12.addBox(-5,-8,3,1,7,2);
        this.dKnightHead.addChild(helmet12);

        ModelRenderer helmet13 = new ModelRenderer(this, 12, 41);
        helmet13.addBox(-4,-8,4,8,7,1);
        this.dKnightHead.addChild(helmet13);

        ModelRenderer helmet14 = new ModelRenderer(this, 30, 41);
        helmet14.addBox(-4,-8,-4,8,1,8);
        this.dKnightHead.addChild(helmet14);
        //body
        this.dKnightBody = new ModelRenderer(this, 0, 50);
        this.dKnightBody.addBox(-4,3,-2,8,12,4);
        //leftArm
        this.dKnightLeftArm = new ModelRenderer(this, 24, 50);
        this.dKnightLeftArm.addBox(4,3,-2,4,12,4);
        //rightArm
        this.dKnightRghtArm = new ModelRenderer(this, 40, 50);
        this.dKnightRghtArm.addBox(-8,3,-2,4,12,4);

    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.dKnightHead.render(scale);
        this.dKnightBody.render(scale);
        this.dKnightRghtArm.render(scale);
        this.dKnightLeftArm.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.dKnightHead.rotateAngleY = netHeadYaw * 0.017453292F;
        this.dKnightHead.rotateAngleX = headPitch * 0.017453292F;
        this.dKnightRghtArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.7F * limbSwingAmount * 0.5F;
        this.dKnightLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.7F * limbSwingAmount * 0.5F;

        if (isHolding) {
            if(itemStack != null) {
                dKnightRghtArm.rotateAngleX = -0.3F;
            }
        }
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
        if(entitylivingbaseIn instanceof MobDarkenedKnight) {
            MobDarkenedKnight mobDarkenedKnight = (MobDarkenedKnight) entitylivingbaseIn;
            isHolding = mobDarkenedKnight.getHeldItemMainhand() != null || !mobDarkenedKnight.getHeldItemMainhand().isEmpty();
        }
    }
}
