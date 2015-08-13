package fr.cea.ig.grools.genome_properties;
/*
 * Copyright LABGeM 12/08/15
 *
 * author: Jonathan MERCIER
 *
 * This software is a computer program whose purpose is to annotate a complete genome.
 *
 * This software is governed by the CeCILL  license under French law and
 * abiding by the rules of distribution of free software.  You can  use,
 * modify and/ or redistribute the software under the terms of the CeCILL
 * license as circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 *
 * As a counterpart to the access to the source code and  rights to copy,
 * modify and redistribute granted by the license, users are provided only
 * with a limited warranty  and the software's author,  the holder of the
 * economic rights,  and the successive licensors  have only  limited
 * liability.
 *
 * In this respect, the user's attention is drawn to the risks associated
 * with loading,  using,  modifying and/or developing or reproducing the
 * software by the user in light of its specific status of free software,
 * that may mean  that it is complicated to manipulate,  and  that  also
 * therefore means  that it is reserved for developers  and  experienced
 * professionals having in-depth computer knowledge. Users are therefore
 * encouraged to load and test the software's suitability as regards their
 * requirements in conditions enabling the security of their systems and/or
 * data to be ensured and,  more generally, to use and operate it in the
 * same conditions as regards security.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL license and that you accept its terms.
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;


import fr.cea.ig.grools.genome_properties.model.GenomePropertyImpl;
import fr.cea.ig.grools.genome_properties.model.Term;
import java.net.URL;
//import java.util.Set;

public class GenomePropertiesParserTest {
    private GenomePropertiesParser genomePropertiesParser;
    private static URL file = Thread.currentThread().getContextClassLoader()
                                                    .getResource("GenProp_3.2_release.RDF");



    @Before
    public void setUp(){
        try {
            genomePropertiesParser = new GenomePropertiesParser( file.getPath() );
        } catch ( Exception e) {
            e.printStackTrace();
        }
        assertNotNull( genomePropertiesParser );
    }

    @Test
    public void testGetTerm() {
        final Term term    = genomePropertiesParser.getTerm("gp:Genome_Property_51171");
        assertEquals( term.getId(), "51171" );
        assertTrue( term instanceof GenomePropertyImpl);
        GenomePropertyImpl genomeProperty = (GenomePropertyImpl)term;
        assertEquals(genomeProperty.getAccession()  , "GenProp0193");
        assertEquals(genomeProperty.getCategory()   , "PATHWAY");
        assertEquals(genomeProperty.getThreshold()  , 6);
        assertEquals(genomeProperty.getTitle()      , "lysine biosynthesis via alpha-aminoadipate (AAA pathway)");
        assertEquals(genomeProperty.getDefinition() , "Lysine biosynthesis in fungi has been characterized and begins with the condensation of 2-oxoglutarate and acetyl-CoA to homocitrate and continues through the distinctive intermediate, alpha-aminoadipate. This pathway is distinct in every respect from the diaminopimelate pathway commonly found in bacteria and animals. Recently, an alpha-aminoadipate pathway closely related to the fungal version has been characterized in Thermus thermophilus [1] and appears to be widely distributed among the archaea.");
    }

//    @Test
//    public void validateConstraint(){
//        final Term                              term                    = genomePropertiesParser.getTerm("Property_Component_63099");
//        final ValidatorFactory                  factory                 = Validation.buildDefaultValidatorFactory();
//        final Validator                         validator               = factory.getValidator();
//        final Set<ConstraintViolation<Term>>    constraintViolations    = validator.validate(term);
//        assertTrue(constraintViolations.size() == 0);
//    }
}
