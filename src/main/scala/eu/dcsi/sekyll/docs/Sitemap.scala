package eu.dcsi.sekyll.docs

import java.io.File
import java.nio.file.Files

import scala.xml.{Node, NodeSeq, PrettyPrinter, XML}

object Sitemap {

  def generateSitemapIndex(baseUrl: String, names: Seq[String]) = {
    <sitemapindex xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
      {names.map { name =>
      <sitemap>
        <loc>{baseUrl}/{name}</loc>
      </sitemap>
      }}
    </sitemapindex>
  }

  def generateSitemap(baseUrl: String, urls: Seq[SitemapUrl]) = {
    <urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9">
      {urls.map { url =>
      <url>
        <loc>{baseUrl}/{url.path}</loc>
        <priority>{url.priority}</priority>
      </url>
      }}
    </urlset>
  }

  def writeXml(file: File, xml: Node) = {
    val prettyPrinter = new PrettyPrinter(160, 2)
    val xmlStr = prettyPrinter.format(xml)
    Files.write(file.toPath, xmlStr.getBytes("utf-8"))
    file
  }

  def generateSitemaps(outputDir: File, baseUrl: String, sitemaps: Seq[Sitemap]): Seq[File] = {
    val indexFile = new File(outputDir, "sitemap-index.xml")

    sitemaps.map { sitemap =>
      writeXml(new File(outputDir, sitemap.name), generateSitemap(baseUrl, sitemap.urls))
    } :+ writeXml(indexFile, generateSitemapIndex(baseUrl, sitemaps.map(_.name)))
  }

}

case class Sitemap(name: String, urls: Seq[SitemapUrl])
case class SitemapUrl(path: String, priority: String = "0.5")
