package com.LakeCountryGames.plugin;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.arguments.system.RequiredArg;
import com.hypixel.hytale.server.core.command.system.arguments.types.ArgTypes;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.permissions.HytalePermissions;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import javax.annotation.Nonnull;

public class GetPlayerCommand extends AbstractPlayerCommand {
    @Nonnull
    private final RequiredArg<PlayerRef> targetPlayerArg = this.withRequiredArg(
            "targetPlayer", "The target player to get information for", ArgTypes.PLAYER_REF
    );

    public GetPlayerCommand() {
        super("getplayer","A command to see player information");
        this.requirePermission(HytalePermissions.fromCommand("teleport.self"));
    }

    @Override
    protected void execute(
            @Nonnull CommandContext context, @Nonnull Store<EntityStore> store, @Nonnull Ref<EntityStore> ref, @Nonnull PlayerRef playerRef, @Nonnull World world
    ) {
        PlayerRef targetPlayerRef = this.targetPlayerArg.get(context);
        //Ref<EntityStore> targetRef = targetPlayerRef.getReference();

        context.sendMessage(Message.translation("Players UUID: " + targetPlayerRef.getUuid()));
    }
}
