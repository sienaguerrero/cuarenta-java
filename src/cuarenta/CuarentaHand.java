package cuarenta;

public class CuarentaHand
{
    Vector<Card> cards;
	Deck deck;
	boolean player;

	public BlackjackHand(Deck d, boolean p)
	{
		deck=d;
		cards = new Vector();
		player = p;
	}

	public void setShow(boolean p)
	{
		player = p;
	}

	public void hit()
	{
		cards.add(deck.deal());
	}

	public void clear()
	{
		for(int i = 0; i < cards.size(); i++)
			deck.add(cards.get(i));
		cards = new Vector();
	}

	public int getValue()
	{
		int aces = 0;
		int value = 0;
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i).getBJValue() == 11)
				aces++;
			value+=cards.get(i).getBJValue();
		}
		while((value > 21) && (aces > 0))
		{
			value-=10;
			aces--;
		}
		return value;
	}

	public boolean busted()
	{
		return getValue() > 21;
	}
}

