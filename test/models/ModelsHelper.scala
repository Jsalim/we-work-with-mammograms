package models

import com.avaje.ebean.Ebean
import play.core.j.JavaGlobalSettingsAdapter
import play.api.test.FakeApplication
import helpers.TestSetup.testGlobalSettings
import org.scalatest.{ FunSpec, BeforeAndAfterEach, Matchers }
import scala.reflect.ClassTag
import play.db.ebean.Model

trait ModelsHelper extends FunSpec with BeforeAndAfterEach with Matchers {
  var app: FakeApplication = _

  override def beforeEach() {
    val globalSettings = new JavaGlobalSettingsAdapter(testGlobalSettings)
    app = FakeApplication(withGlobal = Some(globalSettings))
  }

  def rowCount[T <: Model: ClassTag]: Int = Ebean.find(implicitly[ClassTag[T]].runtimeClass).findRowCount()

  def getDbRecord[T <: Model: ClassTag]: Option[T] = {
    val clazz = implicitly[ClassTag[T]].runtimeClass
    val result = Ebean.find(clazz)
    val iterator = result.findIterate
    if (iterator.hasNext) Some(iterator.next.asInstanceOf[T]) else None
  }

  def retrieveDbRecord[T <: Model: ClassTag](deleteAfter: Boolean = true)(assertions: T => Unit): Unit = {
    val optionalDbRecord = getDbRecord[T]
    val clazz = implicitly[ClassTag[T]]

    if (optionalDbRecord.isEmpty)
      fail(s"Could not retrieve specified record for class ${clazz.runtimeClass.getName}")
    else
      optionalDbRecord.foreach(assertions)

    if (deleteAfter)
      optionalDbRecord.foreach(_.delete())
  }

  def comparePatients(patientOne: Patient, patientTwo: Patient) {

    patientOne.id should equal(patientTwo.id)

    // Get personal info
    val patientOnePersonalInfo = patientOne.getPersonalInfo
    val patientTwoPersonalInfo = patientTwo.getPersonalInfo

    patientTwoPersonalInfo.getName should equal(patientOnePersonalInfo.getName)
    patientTwoPersonalInfo.getFirstLastName should equal(patientOnePersonalInfo.getFirstLastName)
    patientTwoPersonalInfo.getSecondLastName should equal(patientOnePersonalInfo.getSecondLastName)
  }

}