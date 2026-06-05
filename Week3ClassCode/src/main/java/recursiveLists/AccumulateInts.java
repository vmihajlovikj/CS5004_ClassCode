package recursiveLists;

public class AccumulateInts implements Accumulator<Integer, Integer> {

  @Override
  public Integer evaluate(Integer value, Integer resultSoFar) {
    return value + resultSoFar;
  }
}
