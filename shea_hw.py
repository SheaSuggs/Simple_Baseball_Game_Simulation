def getLabGrades(nlg, nlt=10, lowGrade=0, highGrade=10):
    labs = _createList(nlt) # create a list of 10 zeros
    return _gradeUpdater(nlg, labs, lowGrade, highGrade)

def _gradeUpdater(numOfEntries, gradeList, lowGrade, highGrade):
    if numOfEntries <= len(gradeList): # make sure grades entered is less than total grades 
        for i in range(numOfEntries):
            grade = float(input("Enter grade: "))
            if grade < lowGrade or grade > highGrade:
                grade = float(input(f"Grade must be between {lowGrade}-{highGrade} please enter new grade"))
            gradeList[i] = grade
        return gradeList

def _createList(size):
    return size * [0]

def getProgramGrades(numOfGrades, totalPrograms=10, lowGrade=0, highGrade=40):
    gradeList = _createList(totalPrograms)
    return _gradeUpdater(numOfGrades, gradeList, lowGrade, highGrade)

def getExamGrades(numOfGrades, totalExams=4, lowGrade=0, highGrade=200):
    examList = _createList(totalExams)
    examsInRanges = 0 # this flag will be use to enuse exams are of the proper score
    while True:
        examsList = _gradeUpdater(numOfGrades, examList, lowGrade, highGrade)
        for i in examList:
            if i > 100:
                examsInRange +=1
        if examsInRanges > 1:
            continue
        else:
            return examsList

def getCurrentAverage(examList, projectList, labList, adjPoints=0):
   """
   Assumes that all grades have been entered in to each list.
   This function does not account for partial grade entries

   function allows for adjuested points. Meaning if the grades list
   are not complete an adjusted total can be entered
   """
   
   totalPoints = 1000 if not adjPoints else adjPoints
   grades = examList + projectList + labList # concat into one list to calc the average
   return sum(grades) / totalPoints

def getCurrentGrade(grade):
    if grade >= .9:
        return "A"
    elif grade >= .8 and grade < .9:
        return "B"
    elif grade >=.7 and grade < .8:
        return "C"
    elif grade >= .6 and grade < .7:
        return "D"
    elif grade < .6:
        return "F"

def main():
    labGrades = getLabGrades(1)
    examGrades = getExamGrades(1)
    progGrades = getProgramGrades(1)
    avg = getCurrentAverage(labGrades, examGrades, progGrades, adjPoints=150) # adjusting points to 150 for testings
    print("This is your current Grade: ", getCurrentGrade(avg))
