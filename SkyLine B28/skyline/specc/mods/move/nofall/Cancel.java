package skyline.specc.mods.move.nofall;

import net.minecraft.MoveEvents.UpdateEvent;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C03PacketPlayer.C06PacketPlayerPosLook;
import skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.event.eventtypes.EventPacket;
import skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.event.main.EventListener;
import skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.skyline.mod.ModMode;
import skyline.specc.mods.combat.KillAuraMod;
import skyline.specc.mods.move.NoFall;

public class Cancel extends ModMode<NoFall> {

	public Cancel(NoFall parent, String name) {
		super(parent, name);
	}
	
	@EventListener
	public void onPacketSend(EventPacket event) {
		if (event.getType() == EventPacket.EventPacketType.SEND) {
			if (event.getPacket() instanceof C03PacketPlayer) {
				C03PacketPlayer packet = (C03PacketPlayer) event.getPacket();
				if (mc.thePlayer.fallDistance > 5.0f) {
					mc.thePlayer.fallDistance = 0.0F;
					mc.thePlayer.sendQueue.addToSendQueue
					(new C06PacketPlayerPosLook(
					mc.thePlayer.posX, mc.thePlayer.posY,
					mc.thePlayer.posZ, mc.thePlayer.rotationYaw,
					mc.thePlayer.rotationPitch, true));
				}
			}
		}
	}
}
