package com.automatatutor.model

import net.liftweb.mapper.MappedString
import net.liftweb.mapper.LongKeyedMapper
import net.liftweb.mapper.LongKeyedMetaMapper
import net.liftweb.mapper.MappedLongForeignKey
import net.liftweb.mapper.IdPK
import net.liftweb.mapper.By
import net.liftweb.mapper.MappedText
import scala.xml.XML
import scala.xml.NodeSeq

class RegExConstructionProblem extends LongKeyedMapper[RegExConstructionProblem] with IdPK {
	def getSingleton = RegExConstructionProblem

	object problemId extends MappedLongForeignKey(this, Problem)
	object regEx extends MappedText(this)
	object alphabet extends MappedText(this)
	
}

object RegExConstructionProblem extends RegExConstructionProblem with LongKeyedMetaMapper[RegExConstructionProblem] {
	def findByGeneralProblem(generalProblem : Problem) : RegExConstructionProblem =
	  find(By(RegExConstructionProblem.problemId, generalProblem)) openOrThrowException("Must only be called if we are sure that generalProblem is a RegExConstructionProblem")
}