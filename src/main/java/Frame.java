class Frame {

    public Frame suivante() {
        final Score scorePremierLancé = premierLance.score();
        if (deuxiemeLance != Lance.vide() || scorePremierLancé.equals(new Score(10))) {
            return new Frame();
        }
        return this;
    }

    public void lance(final Lance lance) {
        if (premierLance == Lance.vide()) {
            premierLance = lance;
            return;
        }
        deuxiemeLance = lance;
    }

    public Score score(final Frames frames) {
        return sommeDesLances().plus(regleSpare(frames), regleStrike(frames));
    }

    protected Score sommeDesLances() {
        final Score scorePremierLancé = premierLance.score();
        final Score scoreDeuxièmeLancé = deuxiemeLance.score();
        return scorePremierLancé.plus(scoreDeuxièmeLancé);
    }

    private Score regleStrike(final Frames frames) {
        final Score scorePremierLancé = premierLance.score();
        if (scorePremierLancé.equals(new Score(10))) {
            final Frame frameSuivante = frames.suivante(this);
            return frameSuivante.bonusStrike(frames);
        }
        return new Score(0);
    }

    public Score bonusStrike(final Frames frames) {
        final Score scorePremierLancé = premierLance.score();
        if(scorePremierLancé.equals(new Score(10))) {
            final Frame frameSuivante = frames.suivante(this);
            return scorePremierLancé.plus(frameSuivante.bonusSpare());
        }
        return sommeDesLances();
    }

    private Score regleSpare(final Frames frames) {
        if (sommeDesLances().equals(new Score(10)) && !premierLance.score().equals(new Score(10))) {
            return frames.suivante(this).bonusSpare();
        }
        return new Score(0);
    }

    public Score bonusSpare() {
        return premierLance.score();
    }

    protected Lance premierLance = Lance.vide();
    protected Lance deuxiemeLance = Lance.vide();
}
