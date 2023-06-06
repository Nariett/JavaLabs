<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <head>
                <title>Computer</title>
            </head>
            <body>
                <table border="1">
                    <tr>
                        <th>Name</th>
                        <th>Origin</th>
                        <th>Price</th>
                        <th>Type</th>
                        <th>Critical</th>
                    </tr>
                    <xsl:for-each select="Devices/Device">
                        <tr>
                            <td><xsl:value-of select="Name"/></td>
                            <td><xsl:value-of select="Origin"/></td>
                            <td><xsl:value-of select="Price"/></td>
                            <td>
                                <xsl:for-each select="Types/Type">
                                    <xsl:value-of select="."/>
                                    <xsl:if test="position() != last()">, </xsl:if>
                                </xsl:for-each>
                            </td>
                            <td><xsl:value-of select="Critical"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>