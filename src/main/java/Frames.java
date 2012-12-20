import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

class Frames implements Iterable<Frame> {
    public void lance(final Lance lance) {
        calculFrameSuivante();
        frameCourante.lance(lance);
    }

    private void calculFrameSuivante() {
        Frame suivante = frameSuivante();
        if(!valeurs.contains(suivante)) {
            valeurs.add(suivante);
            frameCourante = suivante;
        }
    }

    private Frame frameSuivante() {
        if(valeurs.size() == 10) {
            return valeurs.get(9);
        }
        final Frame resultat = frameCourante.suivante();
        if(resultat != frameCourante && valeurs.size() == 9) {
            return new DerniereFrame();
        }
        return resultat;
    }

    @Override
    public Iterator<Frame> iterator() {
        return valeurs.iterator();
    }

    public Frame suivante(final Frame frame) {
        return valeurs.get(valeurs.indexOf(frame) +1);
    }

    private Frame frameCourante = new Frame();
    private List<Frame> valeurs = Lists.newArrayList();
}
