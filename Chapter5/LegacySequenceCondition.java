package Chapter5;

public class LegacySequenceCondition {
    private int sequence;

    public LegacySequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    private boolean isSatisfiedBySequence(Screening screening) {
        return sequence == screening.getSequence();
    }

}
