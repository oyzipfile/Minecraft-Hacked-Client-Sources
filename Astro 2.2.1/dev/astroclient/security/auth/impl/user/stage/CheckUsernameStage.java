package dev.astroclient.security.auth.impl.user.stage;

import com.google.gson.JsonObject;
import dev.astroclient.client.Client;
import dev.astroclient.security.auth.IStage;
import dev.astroclient.security.indirection.MethodIndirection;
import dev.astroclient.security.web.DataRetriever;
import dev.astroclient.security.web.url.Decoder;
import dev.astroclient.security.web.url.store.SimpleStoreManager;
import dev.astroclient.security.web.url.store.impl.UUIDStore;

public class CheckUsernameStage implements IStage {

    @Override
    public byte getStage() {
        return 1;
    }

    @Override
    public boolean pass() {
        return true;
    }
}
