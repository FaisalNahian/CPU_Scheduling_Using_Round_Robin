public class CPU
{
  private int time;
  private Process process;

  public CPU()
  {
    time = 0;
    process = null;
  }

  public boolean acceptProcess(Process process)
  {
    if (isProcessing()) {
      return false;
    }
    this.process = process;
    this.process.setServiceTime(time);

    return true;
  }
// Process Processes
  public boolean doProcess()
  {
    if (!isProcessing()) {
      return false;
    }
    if (process.decreaseQuantumTime())
    {
      if (process.isFinished()) {
        process.setFinishTime(time);
      }
      return true;
    }
    return false;
  }

  public Process getProcess()
  {
    return process;
  }

  public boolean isProcessing()
  {
    return process != null;
  }

  public void incrementTime()
  {
    time += 1;
  }

  public int getTime()
  {
    return time;
  }

  public boolean hasFinishedProcess()
  {
    return process.isFinished();
  }

  public void clearProcess()
  {
    process = null;
  }
}
