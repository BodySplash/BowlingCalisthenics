class DerniereFrame extends Frame {

    @Override
    public void lance(final Lance lance) {
        if(deuxiemeLance != Lance.vide()) {
            dernierLance = lance;
            return;
        }
        super.lance(lance);
    }


    @Override
    public Score score(final Frames frames) {
        final Score scorePremierLancé = premierLance.score();
        final Score scoreDeuxiemeLancé = deuxiemeLance.score();
        final Score scoreDernierLancé = dernierLance.score();
        if(premierLance.score().equals(new Score(10))) {
            return scorePremierLancé.plus(scoreDeuxiemeLancé, scoreDernierLancé);
        }
        if(scorePremierLancé.plus(scoreDeuxiemeLancé) == new Score(10)) {
            return sommeDesLances().plus(scoreDernierLancé);
        }
        return sommeDesLances();
    }

    @Override
    public Score bonusStrike(final Frames frames) {
        return sommeDesLances();
    }

    private Lance dernierLance = Lance.vide();
}
