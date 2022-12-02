package io.github.knifeofdreams.adventofcode.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.knifeofdreams.adventofcode.day1.ElfCalories;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ElfCaloriesTest {

  public static final List<List<Integer>> CALORIES = List.of(List.of(20576, 21113, 1865),List.of(2343, 3759, 4671, 3514, 6866, 4546, 3609, 6326, 5906, 5442, 5195, 5583, 2710),List.of(16332, 2699, 3741, 7185, 5896),List.of(    2267, 3893, 2980, 2947, 3050, 4802, 3632, 3782, 3496, 2039, 5480, 4251, 1354,    4110, 3729),List.of(18422, 14719, 12219, 9338),List.of(3508, 14810, 7562),List.of(26427),List.of(50479),List.of(3728, 2075, 2833, 3230, 5686, 4192, 6422, 3889, 3909, 5401, 2133, 4783, 4033),List.of(    5427, 5821, 5961, 2101, 5372, 3020, 1967, 1515, 3524, 1501, 5739, 4338, 1101,    1814),List.of(31305, 16702),List.of(4486, 9183, 8344, 12223, 7689, 3016),List.of(8393, 8685, 13413, 10985, 8315, 3788),List.of(13014, 3271, 9400, 1992, 12994),List.of(11346, 10251, 4907, 10542, 7255, 1851, 10403),List.of(54808),List.of(22212, 20801, 21801),List.of(5884, 5430, 2035, 1874, 12640, 8107),List.of(5482, 6859, 5162, 8539, 6095, 5773, 6728, 1805),List.of(4318, 7332, 3963, 8325, 1885, 2389, 5016, 3755, 2506, 7459),List.of(8462, 8625, 5314, 4225, 4490, 5034, 5831, 9497),List.of(    1372, 4798, 1102, 3997, 3807, 2653, 1825, 1917, 3496, 3109, 5821, 2541, 1985,    5603, 4429),List.of(2610, 2675, 4421, 6752, 9773, 11199),List.of(1461, 4542, 3911, 5062, 2511, 2698, 2349, 1237, 5175, 5261, 2584, 5874, 4620),List.of(3224, 2819, 3777, 1928, 5084, 4794, 6603, 5089, 1712, 3575, 6366, 4996),List.of(11590, 15298),List.of(1732, 5735, 4073, 8618, 3323, 9048, 4057, 1730, 1352),List.of(    6099, 4661, 4859, 6238, 5420, 4029, 6304, 4408, 1153, 3267, 5079, 5316, 4313,    2053),List.of(3558, 7386, 4576, 3634, 5316, 2514, 10040, 1142),List.of(6295, 7089, 3635, 7431, 4617, 1446, 2176, 3275, 2918, 1017, 4783, 7275),List.of(5394, 6103, 12373, 11996, 11705),List.of(7358, 1411, 6453, 8222, 2769, 1876),List.of(11664, 23449),List.of(5790, 5169, 5938, 4629, 7410, 2332, 4168, 3862),List.of(    1178, 2663, 1199, 2213, 2130, 4467, 5858, 2299, 5782, 1258, 2804, 2389, 3189,    5331, 1504),List.of(20440),List.of(14518, 37385),List.of(3145, 3261, 6673, 10868, 5418, 5314),List.of(11363, 32647),List.of(43296),List.of(15894, 13236, 15512, 5712, 14246),List.of(6781, 2578, 5618, 5439, 10274, 1150, 9670),List.of(14103, 14290, 18309),List.of(2913, 5225, 6490, 6106, 9720, 3185, 5319, 7907),List.of(4639, 8200, 7643, 6855, 3179, 7296, 1722, 3701, 7727, 4696),List.of(7122, 1790, 1000, 1669, 4656, 1074, 5694, 3842, 2869, 5367, 4835, 5366),List.of(4403, 29252),List.of(    1334, 3957, 6116, 3518, 4336, 5956, 2847, 5139, 4145, 2381, 1033, 1090, 3084,    1006, 5445),List.of(1266, 8219, 11975, 1448, 4872, 5952, 11836),List.of(47039),List.of(2057, 1384, 12248, 5983, 14939),List.of(3365, 1461, 5510, 4133, 5086, 5883, 5206, 1646, 5123, 5439, 2604, 3940, 5788),List.of(    3323, 1300, 5903, 2394, 3720, 3032, 3626, 2745, 1506, 4918, 3444, 4036, 5288,    4577, 1312),List.of(    3799, 4433, 2101, 1111, 1416, 2845, 3917, 3831, 3914, 1470, 5090, 4247, 5826,    4868, 3098),List.of(10489, 3303, 14002),List.of(8497, 8272, 10026, 7923, 1514, 4377),List.of(10675, 6889),List.of(    2209, 1843, 3090, 2872, 3131, 3253, 1451, 4466, 4324, 1846, 5920, 2230, 5032,    4709, 5093),List.of(8069, 2206, 7783, 8083, 2719, 7609, 10018, 5760),List.of(18179, 5920, 19231, 10281),List.of(8784, 3672, 8468, 5364, 6517, 7935, 6765, 4531, 3725),List.of(7255, 5920, 7198, 6102, 3508, 6387, 7393, 1369, 5819, 5501, 4246, 3924),List.of(    3015, 1547, 2789, 5256, 3726, 3730, 3927, 3119, 6072, 5975, 1699, 1298, 1143,    3060, 3621),List.of(4768, 4440, 3737, 6842, 4013, 2782, 4355, 6429, 2795, 6119),List.of(8073, 4257, 6133, 8704, 7760, 1856, 6286, 9540, 4001),List.of(12220, 2290, 11849, 5142, 11334, 2195),List.of(7417, 2521, 6307, 4973, 6115, 4711, 6979, 5766, 4693, 7093, 5102, 6243),List.of(5545, 5788, 6456, 3505, 1417, 2795, 1332, 2246, 5923, 4595, 2625, 5600, 6882),List.of(5151, 1836, 1749, 9667, 5727, 6016, 5880, 8658, 5713),List.of(11762, 19759, 16927, 1676),List.of(1416, 2057, 7261, 6409, 2761, 10013, 4271, 5663),List.of(4043, 13430, 5809, 5137, 5567, 7237),List.of(    2272, 2910, 2347, 4139, 4200, 1151, 2200, 1080, 2377, 1025, 2121, 5555, 4991,    4064, 1581),List.of(4410, 5763, 7428, 2523, 4697, 3205, 2112, 7267, 5998, 5260, 2638),List.of(24158, 11935, 16422),List.of(5646, 8050, 9167, 4442, 8747, 5644, 1432, 9406, 5271),List.of(6935, 5132, 3932, 1403, 3481, 6183, 1379, 3481, 5295, 2469, 6071),List.of(1391, 3909, 3709, 4322, 5556, 5680, 3847, 6440, 1186, 3125, 3309, 1926, 5055),List.of(6720, 2591, 5190, 5752, 6945, 1449, 2342, 5203, 6876, 3126, 5756, 3276, 6033),List.of(    4172, 4948, 3283, 4148, 5099, 1986, 5267, 4268, 2269, 4827, 1848, 2069, 4351,    5824, 3392),List.of(27910, 3719),List.of(1614, 4131, 3647, 1986, 4052, 3567, 6704, 2935, 5863, 4276, 3894, 5633),List.of(4661, 3119, 12461, 6511),List.of(8508, 9046, 9839, 9767, 11123, 11641, 10796),List.of(18066, 13926, 12845, 16772),List.of(3277, 4231, 6197, 3835, 5077, 1997, 4358, 3227, 4468, 3439, 5138, 2119, 5151),List.of(2154, 7536, 8238, 5169, 7593, 4794, 1380, 4787, 3160),List.of(4112, 5593, 1909, 3865, 4222, 5857, 6345, 5754, 6790, 3949, 2151, 6559, 1628),List.of(    4379, 2228, 5188, 4142, 1701, 5397, 3658, 1239, 2550, 4179, 5389, 2819, 3685,    2996),List.of(11002, 13882, 3882, 13706, 11087, 5838),List.of(10144, 10584, 5002, 9792, 5020, 2086, 9097, 2954),List.of(7171, 2630, 8183, 6856, 5022, 2334, 2581, 5043, 7984, 6596),List.of(37145),List.of(7820, 3645, 3311, 10883, 6330, 8016, 10794),List.of(6262, 5203, 5709, 5080, 5320, 2562, 4604, 4126, 4549, 5592, 7500),List.of(1823, 6193),List.of(14600, 1724, 12158, 3864, 2486),List.of(1401, 10132, 16192, 11882),List.of(4823, 1689, 2524, 6377, 7431, 4357, 3713, 7343, 3457, 6712, 3012, 2947),List.of(18318),List.of(30203, 24835),List.of(    4292, 1221, 5654, 5428, 5278, 1575, 4268, 6023, 3891, 6261, 5178, 1550, 1173,    4501),List.of(3036, 12480, 8453, 7215, 3536),List.of(6244, 5588, 2211, 9838, 10042, 4662),List.of(7163, 7724, 6376, 3915, 3922, 5919, 9180, 4421, 3726),List.of(6044, 2245, 9227, 6569, 11782, 2494, 1405),List.of(    2826, 3400, 4664, 5917, 2934, 2817, 2686, 3770, 4318, 2659, 3960, 3752, 2592,    3016),List.of(    3542, 4286, 4291, 1668, 2999, 4739, 1226, 3063, 2509, 4095, 2918, 4427, 3673,    2312),List.of(10232, 6672, 2804, 5236, 10466, 6948, 4811, 8435),List.of(7315, 9233, 9488, 7129, 3549, 8730, 2150, 4258),List.of(    1510, 1286, 1316, 4569, 4419, 1288, 3313, 1076, 2955, 1837, 1263, 3531, 5726,    3300, 4617),List.of(2779, 9026, 4720, 3817, 3701, 9456, 2337, 9127, 8076),List.of(4113, 7168, 7030, 3438, 1686, 5641, 5282, 5710, 7170, 7722, 1365),List.of(14199, 4119, 6337),List.of(7418, 16770, 12037),List.of(    6225, 4693, 5303, 2626, 1008, 4163, 2985, 1425, 4092, 5396, 3417, 6143, 6499,    5619),List.of(    1133, 3945, 4897, 4828, 3642, 2893, 1732, 1247, 1963, 5962, 4106, 3387, 4829,    2595, 5867),List.of(6122, 3406, 6933, 5611, 1044, 4815, 5767, 2562, 2197, 6550, 5551, 3119),List.of(2901, 6744, 3204, 2822, 5068, 4457, 1079),List.of(    4452, 1253, 3943, 6092, 1706, 4791, 3951, 2090, 3114, 1515, 2004, 3980, 6366,    1771),List.of(13893, 11323, 13829, 7168, 14871),List.of(4796, 2089, 7885, 8628, 6715, 4143, 1381, 1412, 5611, 3672),List.of(3768, 4839, 3066, 12255, 2517, 5999),List.of(1810, 2477, 4634, 3880, 5517, 4773, 6438, 5496, 3528, 3022, 5048, 1612),List.of(12728, 11268, 4727, 6643, 6186, 5735),List.of(5856, 4873, 2587, 3053, 2763, 1681, 1641, 4235, 1895, 2865, 3886, 1090),List.of(7837, 3957, 7666, 15287, 4153),List.of(33476, 15842),List.of(20446, 28621),List.of(4257, 2252, 5779, 2424, 3048, 4297, 6185, 3896),List.of(5005, 2248, 4388, 5507, 7246, 5802, 4730, 6816, 1882, 3101, 6888, 7312),List.of(4287, 16345, 11713, 1141, 1576),List.of(5534, 13649, 2963, 10251, 8072),List.of(46888),List.of(19996),List.of(6251, 1783, 2931, 9216, 5802, 6353, 5406, 10761),List.of(8964, 6194, 5594, 2981, 4283, 5227, 1111),List.of(3768, 4065, 1420, 6334, 7126, 3430),List.of(6369, 2958, 2548, 7475, 6389, 5121, 8008, 1957, 4481, 8452),List.of(2985, 7921, 7868, 9901, 4221, 8815),List.of(12828, 35189),List.of(6415, 3009, 2332, 6851, 5956, 1894, 6421, 4728, 6698, 3628, 2004, 6174, 5251),List.of(5518, 4788, 1959, 5935, 7906, 6064, 5242, 4082, 8573, 4529),List.of(68508),List.of(3847, 3451, 8433, 5073, 4464, 7378, 8997, 8107, 7266),List.of(    3750, 3841, 4113, 5005, 4238, 1316, 4027, 3120, 6083, 3892, 6303, 6364, 1699,    5665),List.of(2863, 5168, 2244, 2180, 6794, 5924, 5793, 2997, 4871, 7578, 1821),List.of(2717, 1900, 4743, 6280, 8703, 1225, 2711, 5260, 3870, 7283),List.of(4323, 9508, 3221, 8294, 4081, 8086, 5465, 10185),List.of(6295, 9301, 2663, 9299, 8681, 2628, 5173, 8236),List.of(    1093, 6211, 6172, 3120, 1545, 5010, 2555, 4503, 6041, 2256, 2054, 3556, 4189,    4079),List.of(4227, 5046, 10539),List.of(16145, 12616, 1897),List.of(10759, 13443, 2817, 5487, 7129, 13704),List.of(9237, 9637, 5517, 5033, 7727, 5903, 7685, 6360, 9147),List.of(11730, 6487, 7984, 4641, 10800, 10737),List.of(2926, 3365, 10511, 1019, 5174, 6880, 10022, 2021),List.of(7561, 1995, 2056, 9535, 12687, 11037),List.of(2986, 7624, 4960, 3148, 3615, 1248, 6271, 7689, 6203),List.of(2078, 6126, 2217, 3778, 2469, 2940, 1009, 3727, 3591, 4631, 6934, 5679, 5212),List.of(7293, 8422, 1249, 9071, 2397, 9070, 7249, 5900, 8496),List.of(18221, 12199, 23082),List.of(2756, 2031, 15919, 8850, 11519),List.of(4213, 4007, 4750, 1689, 6301, 2769, 1822, 5633, 3829, 6259, 1941),List.of(4566, 11741, 2449, 9639, 2853),List.of(    5442, 2931, 3418, 2474, 5999, 3614, 1092, 5745, 2216, 5437, 4653, 1596, 2064,    4568, 3889),List.of(30188, 30811),List.of(6631, 7390, 4365, 10085, 5771, 5407),List.of(    5994, 4371, 4328, 4888, 2557, 4400, 1917, 2487, 5787, 4068, 1608, 4897, 1872,    3580, 1828),List.of(12407, 15919, 18883, 10093),List.of(10235, 18157, 10243),List.of(5020, 7857, 7218, 4726, 5184, 4807, 5762, 6433, 4435, 3292, 2582),List.of(    5435, 3279, 1483, 2174, 4082, 2016, 3470, 1106, 3156, 5028, 3973, 3309, 4918,    4886),List.of(5234, 9601, 9386, 4696, 5400, 3738, 4093),List.of(3468),List.of(2988, 13322, 16091, 6182),List.of(8902, 14057, 24074),List.of(2417, 5580, 5165, 7582, 6674, 6646, 2562, 7885),List.of(4197, 5211, 2837, 6012, 6525, 4345, 3060, 4458, 6405, 6556, 1167, 2705),List.of(3137, 4709, 5239, 3930, 2685, 5421, 2847, 2443, 3801, 3067, 4431, 1073, 6625),List.of(25928),List.of(11278, 3062, 7704, 7328, 2742, 7913, 10850),List.of(4179, 3352),List.of(    5766, 2479, 5510, 2723, 1559, 4851, 2808, 3149, 1900, 5551, 1168, 4292, 2706,    1887),List.of(    5644, 3980, 1953, 1302, 4673, 4792, 5560, 4700, 2098, 4581, 2026, 3986, 3621,    2729, 2734),List.of(    1634, 1891, 5864, 3643, 1622, 1096, 3405, 3519, 4975, 4773, 4544, 4211, 2889,    5510, 5677),List.of(5747, 3716, 1570, 4609, 3562, 1537, 5157, 4558, 4131, 4544, 4445, 5116, 2357),List.of(8035, 15475, 8791, 12796, 1809),List.of(3956, 3423),List.of(4498, 14291, 5435, 11333, 12805),List.of(16130, 15515, 8077, 5292, 14806),List.of(5441, 7830, 8229, 19304),List.of(6133, 6807, 5145, 3100, 2799, 6450, 2844, 7369, 5750, 7453, 6917, 5280),List.of(7733, 6790, 3399, 9413, 9225, 7820, 3627),List.of(10128, 5460, 6217, 1468, 5069, 1867, 2561, 3563),List.of(6203, 1220, 5422, 9143, 8279, 9127, 2197, 7563, 5805),List.of(    5641, 4988, 3833, 6330, 5125, 4818, 4985, 5806, 2835, 2538, 4243, 3944, 1313,    5633),List.of(1670, 3783, 5004, 9925, 2056, 8138, 2273, 5211),List.of(7054, 3876, 4804, 5782, 2864, 4869, 3974, 3365, 7392, 1003, 3421, 2282),List.of(16982, 10310, 9105, 15909),List.of(    4006, 4721, 1089, 3784, 3735, 1462, 3572, 3903, 5100, 3553, 4538, 5008, 3474,    6114, 5023),List.of(7712, 3772, 6012, 3780, 2039, 1225, 4572, 7205, 3724, 2743, 5649),List.of(13835, 16341),List.of(2440, 3526, 5922, 4275, 6518, 7738, 4511, 9176, 6738),List.of(8973, 1525, 11024, 10053, 1167),List.of(6878, 6330, 2436, 6166, 6009, 5824, 5849, 7599, 7667),List.of(6661, 32224),List.of(4835, 4152, 5550, 17374),List.of(4829, 11255, 11845, 8734, 11026, 12040, 2598),List.of(5651, 8148, 7319, 7168, 2570, 2667, 6102, 7372, 1901),List.of(5257, 1897, 5295, 2643, 6499, 6384, 1979, 4897, 6198, 4986, 4463, 6078, 1669),List.of(36617, 9770),List.of(5488, 18324, 3889, 2697),List.of(3909, 5302, 7668, 4954, 4574, 7610, 4162, 1222, 5727, 4826, 4429),List.of(50529),List.of(4561, 7022, 7778, 7386, 2126, 1350, 8767, 1089, 4340, 1013),List.of(2218, 6429, 5964, 1643, 1181, 6695, 6759, 1766, 2985, 3029, 6439, 2646, 6814),List.of(53117),List.of(9836, 6608, 13067, 4747, 10627, 7074),List.of(7382, 7263, 2142, 2197, 3237, 4509, 6866, 1487, 6288, 3515, 4318, 4403),List.of(9503, 7732, 9320, 4184, 4429, 10334, 3313, 5438),List.of(15150, 15460, 14761, 8079, 1070),List.of(2206, 6973, 7571, 2311, 3170, 8153, 7794, 9043, 3857),List.of(    4169, 3297, 1703, 6039, 1189, 4565, 5455, 1584, 4338, 1759, 1854, 1093, 5004,    1133, 2004),List.of(5262, 3782, 2259, 5446, 2978, 6146, 1939, 1805, 4517, 2969, 6390, 2784, 3689),List.of(10342, 6089, 7688, 10383, 4769, 7696, 7393, 10301),List.of(6666, 10943, 1638, 1975, 5509, 5767, 5673),List.of(15320, 23126),List.of(2813, 7182, 3956, 7486, 10251, 4172, 1862, 4006),List.of(15496, 4847, 8430, 1683, 13281),List.of(4685, 3580, 1308, 8183, 6367, 8410, 3052, 3020, 1217),List.of(    4252, 5883, 4079, 3580, 3064, 1385, 4488, 1790, 4826, 3157, 1747, 1783, 3312,    4652),List.of(14551),List.of(3025, 13696, 3537, 4087),List.of(    6169, 5270, 5187, 3572, 3060, 3599, 4252, 4886, 5244, 5231, 1359, 6340, 2142,    4429),List.of(5850, 4447, 7828, 4518, 6431, 5995, 1284, 5499, 1372, 2666, 7721),List.of(1191, 20856),List.of(13838, 2247, 12654, 11027, 9684),List.of(4997, 8716, 6293, 7317, 1002, 5121, 6663, 7838, 1922, 8001),List.of(5614, 13883, 2757, 11574, 3051, 11435),List.of(45664),List.of(2476, 7792, 8480, 7283, 9042, 7090, 5830),List.of(2721, 6238, 8011, 1974, 3526, 2811, 6167, 1778, 3507, 7992),List.of(    3082, 4367, 4463, 1753, 3627, 1468, 2616, 1456, 1033, 1110, 2453, 5058, 1665,    4399, 5720),List.of(4019, 6080, 5496, 3896, 5752, 2673, 2460, 2284, 6342, 1710, 3860, 1223, 4688),List.of(1121, 3153, 2961, 2103, 3816, 6492, 5483, 2086, 6154, 4440, 3196, 1630, 3140),List.of(4140, 6238, 1092, 1218, 5688, 6097, 5695, 3413, 9453),List.of(29041),List.of(3320, 10344, 21501),List.of(8209, 11402, 11152, 6367, 5191, 8598, 8608),List.of(12087, 24388, 22987),List.of(1668, 3447, 7162, 6136, 5098, 1868, 2116, 2716, 1715, 1089, 5410, 5259),List.of(    5913, 3696, 2832, 5618, 3555, 1311, 3641, 2488, 4987, 2104, 2269, 3040, 1706,    3762, 2384),List.of(6731, 2310, 3908, 6314, 1004, 4632, 3402, 2044, 3407, 2833, 1007, 4695),List.of(4894, 9624));
  private ElfCalories elfCalories = new ElfCalories();

  @Nested
  class MaxCalories {
    @Test
    public void choosesMaximumCalorieCount() {
      var calories =
          List.of(
              List.of(1000, 2000, 3000),
              List.of(4000),
              List.of(5000, 6000),
              List.of(7000, 8000, 9000),
              List.of(10000));
      var elfCalories = new ElfCalories();
      assertEquals(24000, elfCalories.maxCalorieCount(calories));
    }

    @Test
    public void choosesMaximumCalorieCountWithMyInput() {
      var calories = CALORIES;
      assertEquals(70720, elfCalories.maxCalorieCount(calories));
    }
  }

  @Nested
  class TopThreeCalories {
    @Test
    public void choosesSumOfTopThreeCalorieCounts() {
      var calories =
          List.of(
              List.of(1000, 2000, 3000),
              List.of(4000),
              List.of(5000, 6000),
              List.of(7000, 8000, 9000),
              List.of(10000));
      assertEquals(45000, elfCalories.sumOfTopThree(calories));
    }

    @Test
    public void choosesSumOfTopThreeCalorieCountsForMyInput() {
      assertEquals(0, elfCalories.sumOfTopThree(CALORIES));
    }
  }
}
