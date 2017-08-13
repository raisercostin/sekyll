package eu.dcsi.website

import play.utils.UriEncoding

case class TreeNode(name: String, icon: String, children: TreeNode*)

object Website {
  val structure = """
Company
Expertise
Solutions
Career
Insights
Contact
"""
  val menu = TreeNode("parent", "0",
    TreeNode("Company", "1",
      TreeNode("Team","1")),
    TreeNode("Expertise", "2",
      TreeNode("Portofolio","1"),
      TreeNode("Clients","1")),
    TreeNode("Solutions", "3",
      TreeNode("Products", ""),
      TreeNode("Development", ""),
      TreeNode("Consultancy", ""),
      TreeNode("Maintenance and Support", ""),
      TreeNode("Academy", "",
      TreeNode("Enterprise", ""),
      TreeNode("Personal", ""))
      ),
    TreeNode("Career", "3",
      TreeNode("Job Openings", "4"),
      TreeNode("Culture", "4")),
    TreeNode("Insights", "3",
      TreeNode("Blog", "4")),
    TreeNode("Contact", "3")
  )
  val first: Seq[String] = structure.split("\n")
}
