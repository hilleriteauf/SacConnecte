package com.saint_gab.sacconnecte;

import java.util.ArrayList;

public class Timetable {

    ArrayList<Subject> mSubjects;
    ArrayList<Lesson>[] mDays;

    public Timetable()
    {
        mDays = new ArrayList[5];
        for(int i=0; i<mDays.length; i++)
        {
            mDays[i] = new ArrayList<>();
        }
        mSubjects = new ArrayList<>();

        mSubjects.add(new Subject("Maths", "#00B81C"));//0
        mSubjects.add(new Subject("Anglais", "#CF3838"));//1
        mSubjects.add(new Subject("Physique", "#b3b3b3"));//2
        mSubjects.add(new Subject("SIN", "#8ce6ff"));//3
        mSubjects.add(new Subject("Etude", "#ffffff"));//4
        mSubjects.add(new Subject("Devoir", "#8b63e0"));//5
        mSubjects.add(new Subject("EPS", "#578ff7"));//6
        mSubjects.add(new Subject("Espagnol", "#fc9d28"));//7
        mSubjects.add(new Subject("ETT LV1", "#ccff33"));//8
        mSubjects.add(new Subject("ETT", "#ff0000"));//9
        mSubjects.add(new Subject("Philo", "#ffdbff"));//10

        mDays[0].add(new Lesson(mSubjects.get(3), "9h25", "12h35"));
        mDays[0].add(new Lesson(mSubjects.get(4), "13h45", "15h35"));
        mDays[0].add(new Lesson(mSubjects.get(7), "15h50", "16h45"));
        mDays[0].add(new Lesson(mSubjects.get(8), "16h45", "17h40"));

        mDays[1].add(new Lesson(mSubjects.get(6), "8h30", "10h20"));
        mDays[1].add(new Lesson(mSubjects.get(9), "10h45", "12h35"));
        mDays[1].add(new Lesson(mSubjects.get(1), "13h45", "14h40"));
        mDays[1].add(new Lesson(mSubjects.get(0), "14h40", "15h35"));
        mDays[1].add(new Lesson(mSubjects.get(4), "15h50", "17h40"));


        mDays[2].add(new Lesson(mSubjects.get(3), "8h30", "10h40"));
        mDays[2].add(new Lesson(mSubjects.get(1), "10h40", "12h35"));
        mDays[2].add(new Lesson(mSubjects.get(9), "13h45", "14h40"));
        mDays[2].add(new Lesson(mSubjects.get(10), "14h40", "16h45"));
        mDays[2].add(new Lesson(mSubjects.get(0), "16h45", "17h40"));


        mDays[3].add(new Lesson(mSubjects.get(2), "8h30", "10h20"));
        mDays[3].add(new Lesson(mSubjects.get(9), "10h45", "12h35"));
        mDays[3].add(new Lesson(mSubjects.get(0), "13h45", "14h40"));
        mDays[3].add(new Lesson(mSubjects.get(7), "14h40", "15h35"));
        mDays[3].add(new Lesson(mSubjects.get(4), "15h50", "16h45"));
        mDays[3].add(new Lesson(mSubjects.get(2), "16h45", "17h40"));


        mDays[4].add(new Lesson(mSubjects.get(5), "8h30", "10h20"));
        mDays[4].add(new Lesson(mSubjects.get(0), "10h45", "11h40"));
        mDays[4].add(new Lesson(mSubjects.get(2), "10h40", "12h35"));
        mDays[4].add(new Lesson(mSubjects.get(3), "13h45", "16h25"));



    }

    public void addSubject(Subject newSubject)
    {
        mSubjects.add(newSubject);
    }

    public void addLesson(Lesson lesson, int dayIndex) {mDays[dayIndex].add(lesson);}

    public void deleteSubject(int index)
    {
        Subject subject = mSubjects.get(index);
        ArrayList<Lesson> lessonsToDelete = subject.getLessons();
        for(int i=0; i<lessonsToDelete.size(); i++)
        {
            for (final ArrayList<Lesson> lessons: mDays)
            {
                if (lessons.contains(lessonsToDelete.get(i))) lessons.remove(lessonsToDelete.get(i));
            }
        }
        lessonsToDelete.clear();
        mSubjects.remove(subject);
    }

    public void deleteLesson(int dayIndex ,int lessonIndex)
    {
        Lesson lesson = mDays[dayIndex].get(lessonIndex);
        lesson.getSubject().removeLesson(lesson);
        mDays[dayIndex].remove(lessonIndex);
    }

    public int getSubjectIndex(Subject subject)
    {
        if (mSubjects.contains(subject)) return mSubjects.indexOf(subject);
        else return 0;
    }

    public ArrayList<Lesson> getLessons(int position)
    {
        return mDays[position];
    }

    public ArrayList<Subject> getSubjects()
    {
        return mSubjects;
    }

    public String[] getSubjectNames()
    {
        String[] subjectNames = new String[mSubjects.size()];
        for (int i=0; i<mSubjects.size(); i++)
        {
            subjectNames[i] = mSubjects.get(i).getName();
        }
        return subjectNames;
    }

    public Subject getSubject(int index) { return mSubjects.get(index); }

    //Création d'un fichier CSV pour sauvegarder l'emploi du temps
    private void saveTimetable()
    {
        String subjectsStr = "";//Premiere ligne du fichier csv qui stocke toutes les matières
        String lessonsStr = "";//Seconde ligne du fichier csv qui stocke tout les cours

        for (int i=0; i < mSubjects.size(); i++)
        {
            subjectsStr += mSubjects.get(i).getName();
            if(i != mSubjects.size() - 1)   subjectsStr += ";";
        }
    }
}