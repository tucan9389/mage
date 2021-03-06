
package mage.cards.h;

import java.util.UUID;
import mage.ObjectColor;
import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.common.cost.SpellsCostIncreasementAllEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Zone;
import mage.filter.common.FilterCreatureCard;
import mage.filter.predicate.Predicates;
import mage.filter.predicate.mageobject.ColorPredicate;

/**
 *
 * @author fireshoes
 */
public final class HighSeas extends CardImpl {
    
    private static final FilterCreatureCard filter = new FilterCreatureCard("Red creature spells and green creature spells");
    static {
        filter.add(Predicates.or(new ColorPredicate(ObjectColor.RED),
                (new ColorPredicate(ObjectColor.GREEN))));
    }

    public HighSeas(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.ENCHANTMENT},"{2}{U}");

        // Red creature spells and green creature spells cost {1} more to cast.
        this.addAbility(new SimpleStaticAbility(Zone.BATTLEFIELD, new SpellsCostIncreasementAllEffect(filter, 1)));
    }

    public HighSeas(final HighSeas card) {
        super(card);
    }

    @Override
    public HighSeas copy() {
        return new HighSeas(this);
    }
}
