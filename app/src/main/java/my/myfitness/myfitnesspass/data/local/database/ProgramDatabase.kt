package my.myfitness.myfitnesspass.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import my.myfitness.myfitnesspass.data.local.dao.ProgramDao
import my.myfitness.myfitnesspass.data.local.entities.Program
import my.myfitness.myfitnesspass.data.local.others.Converters

@Database(
    entities = [Program::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ProgramDatabase : RoomDatabase() {

    abstract fun programDao(): ProgramDao
}