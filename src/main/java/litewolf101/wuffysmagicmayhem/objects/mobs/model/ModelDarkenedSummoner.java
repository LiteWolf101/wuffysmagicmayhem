package litewolf101.wuffysmagicmayhem.objects.mobs.model;

import litewolf101.wuffysmagicmayhem.objects.mobs.MobDarkenedSummoner;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

/**
 * Created by LiteWolf101 on 7/13/2018.
 */
@SideOnly(Side.CLIENT)
public class ModelDarkenedSummoner extends ModelBase {
    public final ModelRenderer summonerHead;
    public final ModelRenderer summonerBody;
    public final ModelRenderer summonerLArm;
    public final ModelRenderer summonerRArm;
    public final ModelRenderer summonerLCastingArm;
    public final ModelRenderer summonerRCastingArm;

    public MobDarkenedSummoner summoner;

    public ModelDarkenedSummoner() {
        this.textureWidth = 96;
        this.textureHeight = 96;

        //head
        this.summonerHead = new ModelRenderer(this,0,0);
        this.summonerHead.addBox(-4,-7,-4,8,8,8);
        //skull
        ModelRenderer skull0 = new ModelRenderer(this,32,0);
        skull0.addBox(-5,-8,-5,10,3,1);
        this.summonerHead.addChild(skull0);

        ModelRenderer skull1 = new ModelRenderer(this,32,7);
        skull1.addBox(3,-5,-5,2,2,1);
        this.summonerHead.addChild(skull1);

        ModelRenderer skull2 = new ModelRenderer(this,0,16);
        skull2.addBox(-1,-5,-5,2,2,1);
        this.summonerHead.addChild(skull2);

        ModelRenderer skull3 = new ModelRenderer(this,32,4);
        skull3.addBox(-5,-5,-5,2,2,1);
        this.summonerHead.addChild(skull3);

        ModelRenderer skull4 = new ModelRenderer(this,32,10);
        skull4.addBox(-5,-3,-5,10,2,1);
        this.summonerHead.addChild(skull4);

        ModelRenderer skull5 = new ModelRenderer(this,0,19);
        skull5.addBox(-4,-1,-5,8,1,1);
        this.summonerHead.addChild(skull5);

        ModelRenderer skull6 = new ModelRenderer(this,18,16);
        skull6.addBox(-3,0,-5,6,3,1);
        this.summonerHead.addChild(skull6);

        ModelRenderer skull7 = new ModelRenderer(this,32,16);
        skull7.addBox(-4,-10,-7,3,3,3);
        this.summonerHead.addChild(skull7);

        ModelRenderer skull8 = new ModelRenderer(this,44,16);
        skull8.addBox(1,-10,-7,3,3,3);
        this.summonerHead.addChild(skull8);

        ModelRenderer skull9 = new ModelRenderer(this,0,22);
        skull9.addBox(-3.5F,-11,-8,2,2,2);
        this.summonerHead.addChild(skull9);

        ModelRenderer skull10 = new ModelRenderer(this,0,26);
        skull10.addBox(1.5F,-11,-8,2,2,2);
        this.summonerHead.addChild(skull10);

        ModelRenderer skull11 = new ModelRenderer(this,0,30);
        skull11.addBox(-3,-13,-8,1,2,1);
        this.summonerHead.addChild(skull11);

        ModelRenderer skull12 = new ModelRenderer(this,0,33);
        skull12.addBox(2,-13,-8,1,2,1);
        this.summonerHead.addChild(skull12);

        ModelRenderer skull13 = new ModelRenderer(this,8,22);
        skull13.addBox(-5,-8,-4,1,8,8);
        this.summonerHead.addChild(skull13);

        ModelRenderer skull14 = new ModelRenderer(this,0,38);
        skull14.addBox(4,-8,-4,1,8,8);
        this.summonerHead.addChild(skull14);

        ModelRenderer skull15 = new ModelRenderer(this,18,38);
        skull15.addBox(-4,-7,4,8,6,1);
        this.summonerHead.addChild(skull15);

        ModelRenderer skull16 = new ModelRenderer(this,18,45);
        skull16.addBox(-3,-6,5,6,4,1);
        this.summonerHead.addChild(skull16);

        ModelRenderer skull17 = new ModelRenderer(this,36,38);
        skull17.addBox(-4,-8,-4,8,1,8);
        this.summonerHead.addChild(skull17);
        //body
        this.summonerBody = new ModelRenderer(this,68,38);
        this.summonerBody.addBox(-4,3,-2,8,12,4);
        //necklace
        ModelRenderer neck0 = new ModelRenderer(this,0,54);
        neck0.addBox(-2,5,-3,4,1,1);
        this.summonerBody.addChild(neck0);

        ModelRenderer neck1 = new ModelRenderer(this,0,56);
        neck1.addBox(-4,4,-3,2,1,1);
        this.summonerBody.addChild(neck1);

        ModelRenderer neck2 = new ModelRenderer(this,10,54);
        neck2.addBox(2,4,-3,2,1,1);
        this.summonerBody.addChild(neck2);

        ModelRenderer neck3 = new ModelRenderer(this,16,54);
        neck3.addBox(-5,3,-2,1,1,4);
        this.summonerBody.addChild(neck3);

        ModelRenderer neck4 = new ModelRenderer(this,26,54);
        neck4.addBox(4,3,-2,1,1,4);
        this.summonerBody.addChild(neck4);

        ModelRenderer neck5 = new ModelRenderer(this,0,59);
        neck5.addBox(-4,4,2,2,1,1);
        this.summonerBody.addChild(neck5);

        ModelRenderer neck6 = new ModelRenderer(this,6,59);
        neck6.addBox(2,4,2,2,1,1);
        this.summonerBody.addChild(neck6);

        ModelRenderer neck7 = new ModelRenderer(this,12,59);
        neck7.addBox(-2,5,2,4,1,1);
        this.summonerBody.addChild(neck7);
        //bonesOnNecklace
        ModelRenderer neck8 = new ModelRenderer(this,22,59);
        neck8.addBox(-1,5,-4,2,2,1);
        this.summonerBody.addChild(neck8);

        ModelRenderer neck9 = new ModelRenderer(this,28,59);
        neck9.addBox(-4,4,-4,1,2,1);
        this.summonerBody.addChild(neck9);

        ModelRenderer neck10 = new ModelRenderer(this,0,62);
        neck10.addBox(3,4,-4,1,2,1);
        this.summonerBody.addChild(neck10);
        //lArm
        this.summonerLArm = new ModelRenderer(this,4,62);
        this.summonerLArm.addBox(4,3,-2,4,12,4);
        //rArm
        this.summonerRArm = new ModelRenderer(this,20,62);
        this.summonerRArm.addBox(-8,3,-2,4,12,4);
        //lCastingArm
        this.summonerLCastingArm = new ModelRenderer(this,4,62);
        this.summonerLCastingArm.addBox(4,3,-2,4,12,4);
        //rCastingArm
        this.summonerRCastingArm = new ModelRenderer(this,20,62);
        this.summonerRCastingArm.addBox(-8,3,-2,4,12,4);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.summonerHead.render(scale);

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        this.summonerBody.render(scale);
        if(summoner.getArmPose() == MobDarkenedSummoner.SummonerArmPose.CASTING){
            this.summonerLCastingArm.render(scale);
            this.summonerRCastingArm.render(scale);
        } else if (summoner.getArmPose() == MobDarkenedSummoner.SummonerArmPose.NORMAL){
            this.summonerLArm.render(scale);
            this.summonerRArm.render(scale);
        }
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glColor4f(1, 1, 1, 1);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.summonerHead.rotateAngleY = netHeadYaw * 0.017453292F;
        this.summonerHead.rotateAngleX = headPitch * 0.017453292F;

        if(summoner.getArmPose() == MobDarkenedSummoner.SummonerArmPose.CASTING) {
            this.summonerRCastingArm.rotationPointZ = 0.0F;
            this.summonerRCastingArm.rotationPointX = -5.0F;
            this.summonerLCastingArm.rotationPointZ = 0.0F;
            this.summonerLCastingArm.rotationPointX = 5.0F;
            this.summonerRCastingArm.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.25F;
            this.summonerLCastingArm.rotateAngleX = MathHelper.cos(ageInTicks * 0.6662F) * 0.25F;
            this.summonerRCastingArm.rotateAngleZ = 2.3561945F;
            this.summonerLCastingArm.rotateAngleZ = -2.3561945F;
            this.summonerRCastingArm.rotateAngleY = 0.0F;
            this.summonerLCastingArm.rotateAngleY = 0.0F;
        } else if (summoner.getArmPose() == MobDarkenedSummoner.SummonerArmPose.NORMAL){
            this.summonerRArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.7F * limbSwingAmount * 0.5F;
            this.summonerLArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.7F * limbSwingAmount * 0.5F;
        }
    }
}
