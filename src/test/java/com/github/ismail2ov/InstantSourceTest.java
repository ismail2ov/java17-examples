package com.github.ismail2ov;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.time.Instant;
import java.time.InstantSource;
import org.junit.jupiter.api.Test;

class InstantSourceTest {

    @Test
    void shouldReturnDurationBetweenStartAndEnd() {
        InstantSource instantSource = mock(InstantSource.class);
        when(instantSource.instant())
            .thenReturn(Instant.ofEpochMilli(1_640_033_566_000L))
            .thenReturn(Instant.ofEpochMilli(1_640_033_567_750L));

        Timer timer = new Timer(instantSource);
        Duration duration = timer.measure(() -> {
        });

        assertThat(duration).isEqualTo(Duration.ofMillis(1_750));
    }
}
