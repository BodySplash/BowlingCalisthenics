public class Partie {
    public void lance(final Lance lance) {
        frames.lance(lance);
    }

    public Score score() {
        Score resultat = new Score(0);
        for (Frame frame : frames) {
            resultat = resultat.plus(frame.score(frames));
        }
        return resultat;
    }


    private Frames frames = new Frames();
}
