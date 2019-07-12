package parsing;

import model.Job;
import model.Tip;

public interface TipBuilder<ITipModel> {

    ITipModel build();

    /**
     *
     * @param jobName
     * @return
     */
    TipBuilder<ITipModel> declareJobs(String jobName, double wage);

    /**
     *
     * @param tipperName
     * @return
     */
    TipBuilder<ITipModel> declareTippers(String tipperName);

    /**
     *
     * @param date
     * @param shiftName
     * @param shiftLength
     * @param shiftJob
     * @param shiftTip
     * @param weather
     * @param timeOfDay
     * @return
     */
    TipBuilder<ITipModel> declareShift(String date,String shiftName, double shiftLength, String shiftJob, Tip shiftTip,
                                       String weather, String timeOfDay);

}
