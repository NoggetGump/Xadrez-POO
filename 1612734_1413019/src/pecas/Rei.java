
package pecas;

import movimentos.Horizontal;
import movimentos.Vertical;
import vetor.Vet;

public class Rei extends Peca
{
	Vertical V = new Vertical();
	Horizontal H = new Horizontal();
	
	public Rei(int x, int y, char cor)
	{
		super(x, y, cor);

		V.addIfTrue(new Vet(v), null , AllMoves, true);
		V.addIfTrue(new Vet(v), null, AllMoves, false);
		H.addIfTrue(new Vet(v), null, AllMoves, true);
		H.addIfTrue(new Vet(v), null, AllMoves, false);
	}
}

package pecas;
