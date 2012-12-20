public class Score {
    public Score(final int valeur) {
        this.valeur = valeur;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Score)) return false;
        final Score score = (Score) o;
        return valeur == score.valeur;

    }

    @Override
    public int hashCode() {
        return valeur;
    }

    public Score plus(final Score... scores) {
        int nouvelleValeur = valeur;
        for (Score score : scores) {
            nouvelleValeur += score.valeur;
        }
        return new Score(nouvelleValeur);
    }

    @Override
    public String toString() {
        return String.valueOf(valeur);
    }

    private int valeur;
}
