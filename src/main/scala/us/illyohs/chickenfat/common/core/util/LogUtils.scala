package us.illyohs.chickenfat.common.core.util

import org.apache.logging.log4j.{LogManager, Logger}

object LogUtils {

  private val log:Logger = LogManager.getLogger(ModInfo.ID)

  def debug(string: String) = log.debug(string)
  def error(string: String) = log.error(string)
  def info(string: String)  = log.info(string)
  def warn(string: String)  = log.warn(string)
}
