public class Lance {
    public static Lance vide() {
        return VIDE;
    }

    public Lance(final int quilles) {
        this.quilles = quilles;
    }

    public Score score() {
        return new Score(quilles);
    }

    private static final Lance VIDE = new Lance(0);


    private int quilles;
}
