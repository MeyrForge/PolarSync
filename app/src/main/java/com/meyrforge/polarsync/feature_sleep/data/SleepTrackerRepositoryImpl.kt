package com.meyrforge.polarsync.feature_sleep.data

import com.meyrforge.polarsync.feature_sleep.data.entities.toSleep
import com.meyrforge.polarsync.feature_sleep.data.entities.toSleepEntity
import com.meyrforge.polarsync.feature_sleep.domain.SleepTrackerRepository
import com.meyrforge.polarsync.feature_sleep.domain.models.Sleep
import javax.inject.Inject

class SleepTrackerRepositoryImpl @Inject constructor(private val sleepDao: SleepDao) : SleepTrackerRepository{
    override suspend fun saveSleep(sleep: Sleep): Long? {
        return sleepDao.insertSleep(sleep.toSleepEntity())
    }

    override suspend fun getSleepsByDate(date: String): Sleep? {
        val sleeps = sleepDao.searchByDate(date)
        return if(sleeps.isNullOrEmpty()){
            Sleep()
        }else{
            sleeps.last().toSleep()
        }
    }
}