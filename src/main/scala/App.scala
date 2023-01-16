import _root_.config.AppConfig
import telegram.KindleBot
import zio._
import zio.config.getConfig
import zio.config.magnolia.descriptor
import zio.config.typesafe.TypesafeConfig

object App extends ZIOAppDefault {

  val config = TypesafeConfig.fromHoconFilePath("src/main/resources/application.conf", descriptor[AppConfig])

  val programExecution =
    for {
      cfg <- getConfig[AppConfig]
      _ <- Ref.Synchronized.make(false).flatMap { started =>
        new KindleBot(cfg.bot.token, cfg.bot.webhookUrl, started).run()
      }
    } yield {}

  def run =
    programExecution.provideLayer(config)
}