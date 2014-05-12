public class Process
{
  private String name;
  private int arrivalTime;
  private int quantumTime;
  private int serviceTime;
  private int waitingTime;
  private int finishTime;
  private int processedQuantumTime;
// Processing the simulation
  public Process(String name, int arrivalTime, int quantumTime)
  {
    this.name = name;
    this.arrivalTime = arrivalTime;
    this.quantumTime = quantumTime;
    processedQuantumTime = 0;
    waitingTime = 0;
    finishTime = 0;
    setServiceTime(-1);
  }

  public void setFinishTime(int finishTime)
  {
    this.finishTime = finishTime;
  }

  public int getFinishTime()
  {
    return finishTime;
  }

  public void incrementWaitingTime()
  {
    waitingTime += 1;
  }

  public void setServiceTime(int serviceTime)
  {
    if (this.serviceTime == -1) {
      this.serviceTime = serviceTime;
    }
  }

  public boolean isFinished()
  {
    return quantumTime == 0;
  }

  public int getProcessedQuantumTime()
  {
    return processedQuantumTime;
  }

  public boolean decreaseQuantumTime()
  {
    if (quantumTime == 0) {
      return false;
    }
    quantumTime -= 1;
    processedQuantumTime += 1;
    return true;
  }

  public int getArrivalTime()
  {
    return arrivalTime;
  }

  public String getName()
  {
    return name;
  }

  public int getQuantumTime()
  {
    return quantumTime;
  }

  public int getWaitingTime()
  {
    return waitingTime;
  }
}