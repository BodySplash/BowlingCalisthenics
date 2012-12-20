import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class TestsPartie {

    @Before
    public void avant() {
        partie = new Partie();
    }

    @Test
    public void peutFaireUnePartieNulle() {
        lanceNFois(20, 0);

        assertThat(partie.score()).isEqualTo(new Score(0));
    }

    @Test
    public void peutFaireUnePartiePasTerrible() {
        lanceNFois(20, 1);

        assertThat(partie.score()).isEqualTo(new Score(20));
    }


    @Test
    public void peutFaireUnSpare() {
        partie.lance(new Lance(3));
        partie.lance(new Lance(7));
        partie.lance(new Lance(4));
        lanceNFois(17, 0);

        assertThat(partie.score()).isEqualTo(new Score(18));
    }

    @Test
    public void peutFaireUnStrike() {
        partie.lance(new Lance(10));
        partie.lance(new Lance(3));
        partie.lance(new Lance(2));
        lanceNFois(16, 0);

        assertThat(partie.score()).isEqualTo(new Score(20));
    }

    @Test
    public void peutFaireDeuxStrikes() {
        partie.lance(new Lance(10));
        partie.lance(new Lance(10));
        partie.lance(new Lance(5));
        partie.lance(new Lance(2));
        lanceNFois(14, 0);

        assertThat(partie.score()).isEqualTo(new Score(49));
    }

    @Test
    public void peutFaireUnePartieParfaite() {
        lanceNFois(12, 10);

        assertThat(partie.score()).isEqualTo(new Score(300));
    }

    private void lanceNFois(final int lances, final int quilles) {
        for (int i = 0; i < lances; i++) {
            partie.lance(new Lance(quilles));
        }
    }

    private Partie partie;
}
