package cc.kune.wave.server;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.waveprotocol.wave.model.waveref.WaveRef;

import cc.kune.core.client.errors.DefaultException;
import cc.kune.core.server.integration.IntegrationTest;
import cc.kune.core.server.integration.IntegrationTestHelper;

import com.google.inject.Inject;
import com.google.wave.api.Wavelet;

public class KuneWaveManagerDefaultTest extends IntegrationTest {

    private static final String MESSAGE = "testing";
    @Inject
    KuneWaveManagerDefault manager;

    @Before
    public void before() {
        new IntegrationTestHelper(this);

    }

    @Test
    public void createWave() throws DefaultException, IOException {
        doLogin();
        final WaveRef waveletName = manager.createWave(MESSAGE, getSiteAdminShortName());
        assertNotNull(waveletName);
        final Wavelet fetchWavelet = manager.fetchWavelet(waveletName);
        assertNotNull(fetchWavelet);
        assertTrue(fetchWavelet.getRootBlip().getContent().contains(MESSAGE));
    }
}
