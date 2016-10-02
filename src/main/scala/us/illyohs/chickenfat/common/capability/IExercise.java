package us.illyohs.chickenfat.common.capability;

public interface IExercise
{
    void setMaxStamina();

    int getMaxStamina();

    void setMaxHunger();

    void setStamina(int stamina);

    int getStamina();

    void setHunger(int hunger);

    int getHunger();

    void setThirst(int thirst);

    int getThirst();
}
