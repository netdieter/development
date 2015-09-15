/**
 * 
 */
package bongtvplugin;

import java.util.HashMap;

/**
 * @author Dieter
 *	1	ARD	x
 *	2	ZDF	x
 *	3	Pro 7	x
 *	5	Kabel 1	x
 *	6	N24		x
 *	7	arte
 *	8	Das Vierte
 *	9	BR
 *	10	3sat	x
 *	11	MDR
 *	12	WDR
 *	13	NDR
*	14	Phoenix
*	15	HR
*	16	rbb
*	17	SWR
*	18	Eurosport
*	19	Tele 5
*	20	Der Kinderkanal
*	35	SAT.1	x
*	36	VOX		x
*	37	RTL 2	x
*	38	ZDF neo
*	39	Super RTL	x
*	40	Eins extra
*	41	DMAX
*	42	VIVA
*	44	Sport 1
*	45	BR alpha
*	46	Nick-ComedyCentral
*	47	Einsfestival
*	49	sixx
*	50	ZDF kultur
*	51	ServusTV
*	52	Eins plus
*	54	ZDF info
 */
public class BongTVChannelMap extends HashMap<String, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BongTVChannelMap() {
		super();
		this.put("tvbrowserdataservice.TvBrowserDataService_main_de_ard", 1);
		this.put("tvbrowserdataservice.TvBrowserDataService_main_de_zdf", 2);
		this.put("tvbrowserdataservice.TvBrowserDataService_main_de_pro7", 3);
		this.put("tvbrowserdataservice.TvBrowserDataService_main_de_kabel1", 5);
		this.put("tvbrowserdataservice.TvBrowserDataService_others_de_n24", 6);
		this.put("tvbrowserdataservice.TvBrowserDataService_others_de_arte", 7);
		this.put("tvbrowserdataservice.TvBrowserDataService_bodostv_de_DASVIERTE", 8);
		this.put("tvbrowserdataservice.TvBrowserDataService_local_de_bfs", 9);
		this.put("tvbrowserdataservice.TvBrowserDataService_others_at_3sat", 10);
		
		this.put("tvbrowserdataservice.TvBrowserDataService_local_de_mdr-sn", 11);
		this.put("tvbrowserdataservice.TvBrowserDataService_local_de_mdr-th", 11);

		this.put("tvbrowserdataservice.TvBrowserDataService_local_de_wdr", 12);

		this.put("tvbrowserdataservice.TvBrowserDataService_local_de_ndr-hh", 13);
		this.put("tvbrowserdataservice.TvBrowserDataService_local_de_ndr-mv", 13);
		this.put("tvbrowserdataservice.TvBrowserDataService_local_de_ndr", 13);
		this.put("tvbrowserdataservice.TvBrowserDataService_local_de_ndr-sh", 13);
		
		this.put("tvbrowserdataservice.TvBrowserDataService_others_de_phoenix", 14);
		this.put("tvbrowserdataservice.TvBrowserDataService_local_de_hr", 15);
		
		this.put("tvbrowserdataservice.TvBrowserDataService_local_de_rbbberlin", 16);
		this.put("tvbrowserdataservice.TvBrowserDataService_local_de_rbbbrandenburg", 16);
		
		this.put("tvbrowserdataservice.TvBrowserDataService_local_de_swr", 17);
		this.put("tvbrowserdataservice.TvBrowserDataService_local_de_swrrp", 17);
		this.put("tvbrowserdataservice.TvBrowserDataService_local_de_swrsr", 17);

		this.put("tvbrowserdataservice.TvBrowserDataService_bodostv_de_EUROSPORT", 18);
		this.put("tvbrowserdataservice.TvBrowserDataService_bodostv_de_EUROSPORT2", 18);

		this.put("tvbrowserdataservice.TvBrowserDataService_others_de_tele5", 19);
		this.put("tvbrowserdataservice.TvBrowserDataService_others_de_kika", 20);
		this.put("tvbrowserdataservice.TvBrowserDataService_main_de_sat1", 35);
		this.put("tvbrowserdataservice.TvBrowserDataService_main_de_vox", 36);
		this.put("tvbrowserdataservice.TvBrowserDataService_main_de_rtl2", 37);
		this.put("tvbrowserdataservice.TvBrowserDataService_digital_de_zdfneo", 38);
		this.put("tvbrowserdataservice.TvBrowserDataService_main_de_superrtl", 39);

		this.put("tvbrowserdataservice.TvBrowserDataService_bodostv_de_DMAX", 41);
		this.put("tvbrowserdataservice.TvBrowserDataService_others_de_VIVA", 42);
		
		this.put("tvbrowserdataservice.TvBrowserDataService_others_de_sport1plus", 44);
		this.put("tvbrowserdataservice.TvBrowserDataService_local_de_br", 45);
		this.put("tvbrowserdataservice.TvBrowserDataService_others_de_COMEDYCENTRAL", 46);
		this.put("tvbrowserdataservice.TvBrowserDataService_digital_de_einstfestival", 47);
		this.put("tvbrowserdataservice.TvBrowserDataService_digital_de_sixx", 49);
		this.put("tvbrowserdataservice.TvBrowserDataService_digital_de_zdftheater", 50);
		this.put("tvbrowserdataservice.TvBrowserDataService_others_de_servus-de", 51);
		this.put("tvbrowserdataservice.TvBrowserDataService_digital_de_einsmuxx", 52);
		this.put("tvbrowserdataservice.TvBrowserDataService_digital_de_zdfinfo", 54);
	}

	
}
