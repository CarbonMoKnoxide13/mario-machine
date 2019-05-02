package bytecode;

import java.util.HashMap;

public class LookupTable {

	private static HashMap byteCodeLookup;

	public LookupTable() {
		byteCodeLookup = new HashMap();
		byteCodeLookup.put(0, "NOP");
		byteCodeLookup.put(1, "LD BC, nn");
		byteCodeLookup.put(2, "LD (BC), A");
		byteCodeLookup.put(3, "INC BC");
		byteCodeLookup.put(4, "INC B");
		byteCodeLookup.put(5, "DEC B");
		byteCodeLookup.put(6, "LD B, n");
		byteCodeLookup.put(7, "RLCA");
		byteCodeLookup.put(8, "LD (nn), SP");
		byteCodeLookup.put(9, "ADD HL, BC");
		byteCodeLookup.put(10, "LD A, (BC)");
		byteCodeLookup.put(11, "DEC BC");
		byteCodeLookup.put(12, "INC C");
		byteCodeLookup.put(13, "DEC C");
		byteCodeLookup.put(14, "LD C, n");
		byteCodeLookup.put(15, "RRCA");
		byteCodeLookup.put(16, "STOP");
		byteCodeLookup.put(17, "LD DE, nn");
		byteCodeLookup.put(18, "LD (DE), A");
		byteCodeLookup.put(19, "INC DE");
		byteCodeLookup.put(20, "INC D");
		byteCodeLookup.put(21, "DEC D");
		byteCodeLookup.put(22, "LD D, n");
		byteCodeLookup.put(23, "RLA");
		byteCodeLookup.put(24, "JR n");
		byteCodeLookup.put(25, "ADD HL, DE");
		byteCodeLookup.put(26, "LD A, (DE)");
		byteCodeLookup.put(27, "DEC DE");
		byteCodeLookup.put(28, "INC E");
		byteCodeLookup.put(29, "DEC E");
		byteCodeLookup.put(30, "LD E, n");
		byteCodeLookup.put(31, "RRA");
		byteCodeLookup.put(32, "JR NZ, *");
		byteCodeLookup.put(33, "LD HL, nn");
		byteCodeLookup.put(34, "LD (HL+), A | LD (HLI), A | LD (HL), A");
		byteCodeLookup.put(35, "INC HL");
		byteCodeLookup.put(36, "INC H");
		byteCodeLookup.put(37, "DEC H");
		byteCodeLookup.put(38, "LD H, n");
		byteCodeLookup.put(39, "DAA");
		byteCodeLookup.put(40, "JR Z, *");//Hex 28
		byteCodeLookup.put(41, "ADD HL, HL");//Hex 29
		byteCodeLookup.put(42, "LD A, (HLI) | LD A, (HL+) | LD A, (HL)");//Hex 2A
		byteCodeLookup.put(43, "DEC HL");//Hex 2B
		byteCodeLookup.put(44, "INC L");//Hex 2C
		byteCodeLookup.put(45, "DEC L");//Hex 2D
		byteCodeLookup.put(46, "LD L, n");//Hex 2E
		byteCodeLookup.put(47, "CPL");//Hex 2F
		byteCodeLookup.put(48, "JR NC, *");//Hex 30
		byteCodeLookup.put(49, "LD SP, nn");//Hex 31
		byteCodeLookup.put(50, "LD (HLD), A | LD (HL-), A | LD (HL), A");//Hex 32
		byteCodeLookup.put(51, "INC SP");//Hex 33
		byteCodeLookup.put(52, "INC (HL)");//Hex 34
		byteCodeLookup.put(53, "DEC (HL)");//Hex 35
		byteCodeLookup.put(54, "LD (HL), n");//Hex 36
		byteCodeLookup.put(55, "SCF");//Hex 37
		byteCodeLookup.put(56, "JR C, *");//Hex 38
		byteCodeLookup.put(57, "ADD HL, SP");//Hex 39
		byteCodeLookup.put(58, "LD A, (HLD) | LD A, (HL-), | LD A, (HL)");//Hex 3A
		byteCodeLookup.put(59, "DEC SP");//Hex 3B
		byteCodeLookup.put(60, "INC A");//Hex 3C
		byteCodeLookup.put(61, "DEC A");//Hex 3D
		byteCodeLookup.put(62, "LD A, #");//Hex 3E
		byteCodeLookup.put(63, "CCF");//Hex 3F
		byteCodeLookup.put(64, "LD B, B");//Hex 40
		byteCodeLookup.put(65, "LD B, C");//Hex 41
		byteCodeLookup.put(66, "LD B, D");//Hex 42
		byteCodeLookup.put(67, "LD B, E");//Hex 43
		byteCodeLookup.put(68, "LD B, H");//Hex 44
		byteCodeLookup.put(69, "LD B, L");//Hex 45
		byteCodeLookup.put(70, "LD B, (HL)");//Hex 46
		byteCodeLookup.put(71, "LD B, A");//Hex 47
		byteCodeLookup.put(72, "LD C, B");//Hex 48
		byteCodeLookup.put(73, "LD C, C");//Hex 49
		byteCodeLookup.put(74, "LD C, D");//Hex 4A
		byteCodeLookup.put(75, "LD C, E");//Hex 4B
		byteCodeLookup.put(76, "LD C, H");//Hex 4C
		byteCodeLookup.put(77, "LD C, L");//Hex 4D
		byteCodeLookup.put(78, "LD C, (HL)");//Hex 4E
		byteCodeLookup.put(79, "LD C, A");//Hex 4F

		byteCodeLookup.put(80, "LD D, B");//Hex 50
		byteCodeLookup.put(81, "LD D, C");//Hex 51
		byteCodeLookup.put(82, "LD D, D");//Hex 52
		byteCodeLookup.put(83, "LD D, E");//Hex 53
		byteCodeLookup.put(84, "LD D, H");//Hex 54
		byteCodeLookup.put(85, "LD D, L");//Hex 55
		byteCodeLookup.put(86, "LD D, (HL)");//Hex 56
		byteCodeLookup.put(87, "LD D, A");//Hex 57

		byteCodeLookup.put(88, "LD E, B");//Hex 58
		byteCodeLookup.put(89, "LD E, C");//Hex 59
		byteCodeLookup.put(90, "LD E, D");//Hex 5A
		byteCodeLookup.put(91, "LD E, E");//Hex 5B
		byteCodeLookup.put(92, "LD E, H");//Hex 5C
		byteCodeLookup.put(93, "LD E, L");//Hex 5D
		byteCodeLookup.put(94, "LD E, (HL)");//Hex 5E
		byteCodeLookup.put(95, "LD E, A");//Hex 5F

		byteCodeLookup.put(96, "LD H, B");//Hex 60
		byteCodeLookup.put(97, "LD H, C");//Hex 61
		byteCodeLookup.put(98, "LD H, D");//Hex 62
		byteCodeLookup.put(99, "LD H, E");//Hex 63
		byteCodeLookup.put(100, "LD H, H");//Hex 64
		byteCodeLookup.put(101, "LD H, L");//Hex 65
		byteCodeLookup.put(102, "LD H, (HL)");//Hex 66
		byteCodeLookup.put(103, "LD H, A");//Hex 67

		byteCodeLookup.put(104, "LD L, B");//Hex 68
		byteCodeLookup.put(105, "LD L, C");//Hex 69
		byteCodeLookup.put(106, "LD L, D");//Hex 6A
		byteCodeLookup.put(107, "LD L, E");//Hex 6B
		byteCodeLookup.put(108, "LD L, H");//Hex 6C
		byteCodeLookup.put(109, "LD L, L");//Hex 6D
		byteCodeLookup.put(110, "LD L, (HL)");//Hex 6E
		byteCodeLookup.put(111, "LD L, A");//Hex 6F

		byteCodeLookup.put(112, "LD (HL), B");//Hex 70
		byteCodeLookup.put(113, "LD (HL), C");//Hex 71
		byteCodeLookup.put(114, "LD (HL), D");//Hex 72
		byteCodeLookup.put(115, "LD (HL), E");//Hex 73
		byteCodeLookup.put(116, "LD (HL), H");//Hex 74
		byteCodeLookup.put(117, "LD (HL), L");//Hex 75
		byteCodeLookup.put(118, "HALT");//Hex 76
		byteCodeLookup.put(119, "LD (HL), A");//Hex 77

		byteCodeLookup.put(120, "LD A, B");//Hex 78
		byteCodeLookup.put(121, "LD A, C");//Hex 79
		byteCodeLookup.put(122, "LD A, D");//Hex 7A
		byteCodeLookup.put(123, "LD A, E");//Hex 7B
		byteCodeLookup.put(124, "LD A, H");//Hex 7C
		byteCodeLookup.put(125, "LD A, L");//Hex 7D
		byteCodeLookup.put(126, "LD A, (HL)");//Hex 7E
		byteCodeLookup.put(127, "LD A, A");//Hex 7F

		byteCodeLookup.put(128, "ADD A, B");//Hex 80
		byteCodeLookup.put(129, "ADD A, C");//Hex 81
		byteCodeLookup.put(130, "ADD A, D");//Hex 82
		byteCodeLookup.put(131, "ADD A, E");//Hex 83
		byteCodeLookup.put(132, "ADD A, H");//Hex 84
		byteCodeLookup.put(133, "ADD A, L");//Hex 85
		byteCodeLookup.put(134, "ADD A, (HL)");//Hex 86
		byteCodeLookup.put(135, "ADD A, A");//Hex 87

		byteCodeLookup.put(136, "ADC A, B");//Hex 88
		byteCodeLookup.put(137, "ADC A, C");//Hex 89
		byteCodeLookup.put(138, "ADC A, D");//Hex 8A
		byteCodeLookup.put(139, "ADC A, E");//Hex 8B
		byteCodeLookup.put(140, "ADC A, H");//Hex 8C
		byteCodeLookup.put(141, "ADC A, L");//Hex 8D
		byteCodeLookup.put(142, "ADC A, (HL)");//Hex 8E
		byteCodeLookup.put(143, "ADC A, A");//Hex 8F

		byteCodeLookup.put(144, "SUB B");//Hex 90
		byteCodeLookup.put(145, "SUB C");//Hex 91
		byteCodeLookup.put(146, "SUB D");//Hex 92
		byteCodeLookup.put(147, "SUB E");//Hex 93
		byteCodeLookup.put(148, "SUB H");//Hex 94
		byteCodeLookup.put(149, "SUB L");//Hex 95
		byteCodeLookup.put(150, "SUB (HL)");//Hex 96
		byteCodeLookup.put(151, "SUB A");//Hex 97

		byteCodeLookup.put(152, "SBC A, B");//Hex 98
		byteCodeLookup.put(153, "SBC A, C");//Hex 99
		byteCodeLookup.put(154, "SBC A, D");//Hex 9A
		byteCodeLookup.put(155, "SBC A, E");//Hex 9B
		byteCodeLookup.put(156, "SBC A, H");//Hex 9C
		byteCodeLookup.put(157, "SBC A, L");//Hex 9D
		byteCodeLookup.put(158, "SBC A, (HL)");//Hex 9E
		byteCodeLookup.put(159, "SBC A, A");//Hex 9F

		byteCodeLookup.put(160, "AND B");//Hex A0
		byteCodeLookup.put(161, "AND C");//Hex A1
		byteCodeLookup.put(162, "AND D");//Hex A2
		byteCodeLookup.put(163, "AND E");//Hex A3
		byteCodeLookup.put(164, "AND H");//Hex A4
		byteCodeLookup.put(165, "AND L");//Hex A5
		byteCodeLookup.put(166, "AND (HL)");//Hex A6
		byteCodeLookup.put(167, "AND A");//Hex A7

		byteCodeLookup.put(168, "XOR B");//Hex A8
		byteCodeLookup.put(169, "XOR C");//Hex A9
		byteCodeLookup.put(170, "XOR D");//Hex AA
		byteCodeLookup.put(171, "XOR E");//Hex AB
		byteCodeLookup.put(172, "XOR H");//Hex AC
		byteCodeLookup.put(173, "XOR L");//Hex AD
		byteCodeLookup.put(174, "XOR (HL)");//Hex AE
		byteCodeLookup.put(175, "XOR A");//Hex AF

		byteCodeLookup.put(176, "OR B");//Hex B0
		byteCodeLookup.put(177, "OR C");//Hex B1
		byteCodeLookup.put(178, "OR D");//Hex B2
		byteCodeLookup.put(179, "OR E");//Hex B3
		byteCodeLookup.put(180, "OR H");//Hex B4
		byteCodeLookup.put(181, "OR L");//Hex B5
		byteCodeLookup.put(182, "OR (HL)");//Hex B6
		byteCodeLookup.put(183, "OR A");//Hex B7

		byteCodeLookup.put(184, "CP B");//Hex B8
		byteCodeLookup.put(185, "CP C");//Hex B9
		byteCodeLookup.put(186, "CP D");//Hex BA
		byteCodeLookup.put(187, "CP E");//Hex BB
		byteCodeLookup.put(188, "CP H");//Hex BC
		byteCodeLookup.put(189, "CP L");//Hex BD
		byteCodeLookup.put(190, "CP (HL)");//Hex BE
		byteCodeLookup.put(191, "CP A");//Hex BF

		byteCodeLookup.put(192, "RET NZ");//Hex C0
		byteCodeLookup.put(193, "POP BC");//Hex C1
		byteCodeLookup.put(194, "JP NZ, nn");//Hex C2
		byteCodeLookup.put(195, "JP nn");//Hex C3
		byteCodeLookup.put(196, "CALL NZ, nn");//Hex C4
		byteCodeLookup.put(197, "PUSH BC");//Hex C5
		byteCodeLookup.put(198, "ADD A, #");//Hex C6
		byteCodeLookup.put(199, "RST 00H");//Hex C7

		byteCodeLookup.put(200, "RET Z");//Hex C8
		byteCodeLookup.put(201, "RET");//Hex C9
		byteCodeLookup.put(202, "JP Z, nn");//Hex CA
		byteCodeLookup.put(203, "PREFIX CB (OTHER GRAPHICAL OPS)");//Hex CB
		byteCodeLookup.put(204, "CALL Z, nn");//Hex CC
		byteCodeLookup.put(205, "CALL nn");//Hex CD
		byteCodeLookup.put(206, "ADC A, #");//Hex CE
		byteCodeLookup.put(207, "RST 08H");//Hex CF

		byteCodeLookup.put(208, "RET NC");//Hex D0
		byteCodeLookup.put(209, "POP DE");//Hex D1
		byteCodeLookup.put(210, "JP NC, nn");//Hex D2

		byteCodeLookup.put(212, "CALL NC, nn");//Hex D4
		byteCodeLookup.put(213, "PUSH DE");//Hex D5
		byteCodeLookup.put(214, "SUB #");//Hex D6
		byteCodeLookup.put(215, "RST 10H");//Hex D7
		byteCodeLookup.put(216, "RET C");//Hex D8
		byteCodeLookup.put(217, "RETI");//Hex D9
		byteCodeLookup.put(218, "JP C, nn");//Hex DA
		byteCodeLookup.put(220, "CALL C, nn");//Hex DC
		byteCodeLookup.put(222, "SBC A, # (May be incorrect)");//Hex DE
		byteCodeLookup.put(223, "RST 18H");//Hex DF

		byteCodeLookup.put(224, "LD ($FF00+n), A");//Hex E0
		byteCodeLookup.put(225, "POP HL");//Hex E1
		byteCodeLookup.put(226, "LD ($FF00+C), A");//Hex E2
		byteCodeLookup.put(229, "PUSH HL");//Hex E5
		byteCodeLookup.put(230, "AND #");//Hex E6
		byteCodeLookup.put(231, "RST 20H");//Hex E7
		byteCodeLookup.put(232, "ADD SP, #");//Hex E8
		byteCodeLookup.put(233, "JP (HL)");//Hex E9
		byteCodeLookup.put(234, "LD (nn), A");//Hex EA
		byteCodeLookup.put(238, "XOR *");//Hex EE
		byteCodeLookup.put(239, "RST 28H");//Hex EF

		byteCodeLookup.put(240, "LD A, ($FF00+n)");//Hex F0
		byteCodeLookup.put(241, "POP AF");//Hex F1
		byteCodeLookup.put(242, "LD A, (C)");//Hex F2
		byteCodeLookup.put(243, "DI");//Hex F3
		byteCodeLookup.put(245, "PUSH AF");//Hex F5
		byteCodeLookup.put(246, "OR #");//Hex F6
		byteCodeLookup.put(247, "RST 30H");//Hex F7
		byteCodeLookup.put(248, "LDHL SP, n");//Hex F8
		byteCodeLookup.put(249, "LD SP, HL");//Hex F9
		byteCodeLookup.put(250, "LD A, (nn)");//Hex FA
		byteCodeLookup.put(251, "EI");//Hex FB
		byteCodeLookup.put(254, "CP #");//Hex FE
		byteCodeLookup.put(255, "RST 38H");//Hex FF
	}

	public static String getCommand(int key) {
		return (String)byteCodeLookup.get(key);
	}
}
