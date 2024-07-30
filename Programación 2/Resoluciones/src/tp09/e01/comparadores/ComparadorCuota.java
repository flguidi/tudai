package tp09.e01.comparadores;

import tp09.e01.Socio;
import java.util.Comparator;

public class ComparadorCuota implements Comparator<Socio> {
    @Override
    public int compare(Socio s1, Socio s2) {
        if (s1.isUltimaCuotaPaga() && !s2.isUltimaCuotaPaga())
            return -1;
        else if (!s1.isUltimaCuotaPaga() && s2.isUltimaCuotaPaga())
            return 1;
        else
            return 0;
    }
}
