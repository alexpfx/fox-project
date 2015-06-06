package br.com.alexandrealessi.gdx.fox.base.box2d;

/**
 * Created by alex on 06/06/2015.
 */
public class SoccerContact {
    private ContactType contactType;
    private FixtureUserData elementA;
    private FixtureUserData elementB;

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public FixtureUserData getElementA() {
        return elementA;
    }

    public void setElementA(FixtureUserData elementA) {
        this.elementA = elementA;
    }

    public FixtureUserData getElementB() {
        return elementB;
    }

    public void setElementB(FixtureUserData elementB) {
        this.elementB = elementB;
    }
}
