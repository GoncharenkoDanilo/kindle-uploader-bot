package zio

import com.bot4s.telegram.cats.TelegramBot
import org.asynchttpclient.Dsl.asyncHttpClient
import sttp.client3.asynchttpclient.zio.AsyncHttpClientZioBackend
import zio.interop.catz._

abstract class ZIOAbstractBot(val token: String)
  extends TelegramBot[Task](token, AsyncHttpClientZioBackend.usingClient(zio.Runtime.default, asyncHttpClient()))